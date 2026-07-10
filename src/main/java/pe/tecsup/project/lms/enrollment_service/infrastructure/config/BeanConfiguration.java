package pe.tecsup.project.lms.enrollment_service.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.tecsup.project.lms.enrollment_service.application.CreateEnrollmentUseCaseImpl;
import pe.tecsup.project.lms.enrollment_service.application.port.outbound.ExternalCourseClient;
import pe.tecsup.project.lms.enrollment_service.application.port.outbound.ExternalUserClient;
import pe.tecsup.project.lms.enrollment_service.application.usecases.CreateEnrollmentUseCase;
import pe.tecsup.project.lms.enrollment_service.domain.repository.EnrollmentRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEnrollmentUseCase createEnrollmentUseCase (ExternalUserClient externalUserClient, ExternalCourseClient externalCourseClient, EnrollmentRepository enrollmentRepository) {
        return new CreateEnrollmentUseCaseImpl(externalUserClient, externalCourseClient, enrollmentRepository);
    }
}
