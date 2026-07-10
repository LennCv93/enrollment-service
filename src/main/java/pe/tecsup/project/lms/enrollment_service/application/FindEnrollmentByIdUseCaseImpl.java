package pe.tecsup.project.lms.enrollment_service.application;

import lombok.RequiredArgsConstructor;
import pe.tecsup.project.lms.enrollment_service.application.usecases.FindEnrollmentByIdUseCase;
import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;
import pe.tecsup.project.lms.enrollment_service.domain.repository.EnrollmentRepository;

@RequiredArgsConstructor
public class FindEnrollmentByIdUseCaseImpl implements FindEnrollmentByIdUseCase {

    public final EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment execute(Long id) {
        return enrollmentRepository.findById(id);
    }
}
