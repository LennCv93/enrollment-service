package pe.tecsup.project.lms.enrollment_service.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.tecsup.project.lms.enrollment_service.application.usecases.CreateEnrollmentUseCase;
import pe.tecsup.project.lms.enrollment_service.application.usecases.FindEnrollmentByIdUseCase;
import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;
import pe.tecsup.project.lms.enrollment_service.infrastructure.web.dto.request.EnrollmentRequest;
import pe.tecsup.project.lms.enrollment_service.infrastructure.web.dto.response.EnrollmentByIdResponse;
import pe.tecsup.project.lms.enrollment_service.infrastructure.web.dto.response.EnrollmentResponse;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
@Slf4j
public class EnrollmentController {

    public final CreateEnrollmentUseCase createEnrollmentUseCase;
    public final FindEnrollmentByIdUseCase findEnrollmentByIdUseCase;

    @PostMapping
    public ResponseEntity<EnrollmentResponse> createEnrollment(@RequestBody EnrollmentRequest request) {
        Enrollment enrollment = createEnrollmentUseCase.execute(request.userId, request.courseId);

        return ResponseEntity.ok(
                EnrollmentResponse.builder()
                        .id(enrollment.id)
                        .userId(enrollment.userId)
                        .userName(enrollment.userName)
                        .courseId(enrollment.courseId)
                        .courseName(enrollment.courseName)
                        .instructorName(enrollment.instructorName)
                        .status(enrollment.status)
                        .createdAt(enrollment.createdAt)
                        .updatedAt(enrollment.updatedAt)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentByIdResponse> findById(@PathVariable Long id) {

        Enrollment enrollment = findEnrollmentByIdUseCase.execute(id);

        return ResponseEntity.ok(
                EnrollmentByIdResponse.builder()
                        .id(enrollment.id)
                        .userId(enrollment.userId)
                        .courseId(enrollment.courseId)
                        .status(enrollment.status)
                        .createdAt(enrollment.createdAt)
                        .updatedAt(enrollment.updatedAt)
                        .build()
        );
    }
}
