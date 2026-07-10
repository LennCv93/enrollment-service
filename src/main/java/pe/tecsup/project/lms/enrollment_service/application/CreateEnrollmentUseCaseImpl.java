package pe.tecsup.project.lms.enrollment_service.application;

import lombok.RequiredArgsConstructor;
import pe.tecsup.project.lms.enrollment_service.application.port.outbound.ExternalCourseClient;
import pe.tecsup.project.lms.enrollment_service.application.port.outbound.ExternalUserClient;
import pe.tecsup.project.lms.enrollment_service.application.usecases.CreateEnrollmentUseCase;
import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;
import pe.tecsup.project.lms.enrollment_service.domain.model.EnrollmentStatus;
import pe.tecsup.project.lms.enrollment_service.domain.repository.EnrollmentRepository;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.course.requests.FindCourseByIdRequest;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.course.responses.FindCourseByIdResponse;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.user.requests.FindUserByIdRequest;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.user.responses.FindUserByIdResponse;
import pe.tecsup.project.lms.enrollment_service.infrastructure.kafka.EnrollmentEvent;
import pe.tecsup.project.lms.enrollment_service.infrastructure.kafka.EnrollmentProducer;
import pe.tecsup.project.lms.enrollment_service.infrastructure.kafka.KafkaEvents;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
public class CreateEnrollmentUseCaseImpl implements CreateEnrollmentUseCase {

    public final ExternalUserClient externalUserClient;
    public final ExternalCourseClient externalCourseClient;
    public final EnrollmentRepository enrollmentRepository;
    public final EnrollmentProducer enrollmentProducer;

    @Override
    public Enrollment execute(Long userId, Long courseId) {
        FindUserByIdResponse userResponse = externalUserClient.findById(new FindUserByIdRequest(userId));

        FindCourseByIdResponse courseResponse = externalCourseClient.findById(new FindCourseByIdRequest(courseId));

        Enrollment enrollment = Enrollment.create(userId, courseId, EnrollmentStatus.PENDING_PAYMENT.name());

        Enrollment enrollmentSaved = enrollmentRepository.save(enrollment);

        enrollmentSaved.userName = userResponse.firstName + " " + userResponse.lastName;
        enrollmentSaved.courseName = courseResponse.name;
        enrollmentSaved.instructorName = courseResponse.instructor;

        EnrollmentEvent event = new EnrollmentEvent(
                KafkaEvents.ENROLLMENT_CREATED_EVENT.name(),
                enrollmentSaved.id,
                enrollmentSaved.userId,
                enrollmentSaved.courseId,
                enrollmentSaved.status,
                enrollmentSaved.userName,
                enrollmentSaved.courseName,
                enrollmentSaved.instructorName,
                new Date().getTime()
        );
        enrollmentProducer.sendEnrollmentEvent(event);

        return enrollmentSaved;
    }
}
