package pe.tecsup.project.lms.enrollment_service.application.usecases;

import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;

public interface UpdateEnrollmentUseCase {

    Enrollment execute(Long id, String status);
}
