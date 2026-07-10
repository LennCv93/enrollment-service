package pe.tecsup.project.lms.enrollment_service.domain.repository;

import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;

public interface EnrollmentRepository {

    Enrollment save(Enrollment enrollment);
}
