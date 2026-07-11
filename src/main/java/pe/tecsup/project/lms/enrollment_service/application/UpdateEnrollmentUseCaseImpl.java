package pe.tecsup.project.lms.enrollment_service.application;

import lombok.RequiredArgsConstructor;
import pe.tecsup.project.lms.enrollment_service.application.usecases.UpdateEnrollmentUseCase;
import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;
import pe.tecsup.project.lms.enrollment_service.domain.repository.EnrollmentRepository;

@RequiredArgsConstructor
public class UpdateEnrollmentUseCaseImpl implements UpdateEnrollmentUseCase {

    public final EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment execute(Long id, String status) {
        return enrollmentRepository.update(id, status);
    }
}
