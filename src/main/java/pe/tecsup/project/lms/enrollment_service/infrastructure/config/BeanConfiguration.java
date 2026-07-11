package pe.tecsup.project.lms.enrollment_service.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.tecsup.project.lms.enrollment_service.application.CreateEnrollmentUseCaseImpl;
import pe.tecsup.project.lms.enrollment_service.application.FindEnrollmentByIdUseCaseImpl;
import pe.tecsup.project.lms.enrollment_service.application.UpdateEnrollmentUseCaseImpl;
import pe.tecsup.project.lms.enrollment_service.application.port.outbound.ExternalCourseClient;
import pe.tecsup.project.lms.enrollment_service.application.port.outbound.ExternalUserClient;
import pe.tecsup.project.lms.enrollment_service.application.usecases.CreateEnrollmentUseCase;
import pe.tecsup.project.lms.enrollment_service.application.usecases.FindEnrollmentByIdUseCase;
import pe.tecsup.project.lms.enrollment_service.application.usecases.UpdateEnrollmentUseCase;
import pe.tecsup.project.lms.enrollment_service.domain.repository.EnrollmentRepository;
import pe.tecsup.project.lms.enrollment_service.infrastructure.kafka.EnrollmentProducer;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEnrollmentUseCase createEnrollmentUseCase (ExternalUserClient externalUserClient, ExternalCourseClient externalCourseClient, EnrollmentRepository enrollmentRepository, EnrollmentProducer enrollmentProducer) {
        return new CreateEnrollmentUseCaseImpl(externalUserClient, externalCourseClient, enrollmentRepository, enrollmentProducer);
    }

    @Bean
    public FindEnrollmentByIdUseCase findEnrollmentByIdUseCase (EnrollmentRepository enrollmentRepository) {
        return new FindEnrollmentByIdUseCaseImpl(enrollmentRepository);
    }

    @Bean
    public UpdateEnrollmentUseCase updateEnrollmentUseCase (EnrollmentRepository enrollmentRepository) {
        return new UpdateEnrollmentUseCaseImpl(enrollmentRepository);
    }
}
