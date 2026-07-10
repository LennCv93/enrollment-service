package pe.tecsup.project.lms.enrollment_service.application.usecases;

import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;

public interface CreateEnrollmentUseCase {

    Enrollment execute(Long userId, Long courseId);
}
