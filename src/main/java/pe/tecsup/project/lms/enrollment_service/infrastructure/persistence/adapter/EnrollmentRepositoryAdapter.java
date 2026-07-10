package pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;
import pe.tecsup.project.lms.enrollment_service.domain.repository.EnrollmentRepository;
import pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.entity.EnrollmentEntity;
import pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.mapper.EnrollmentMapper;
import pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.repository.EnrollmentJpaRepository;

@Component
@RequiredArgsConstructor
public class EnrollmentRepositoryAdapter implements EnrollmentRepository {

    public final EnrollmentJpaRepository enrollmentJpaRepository;

    @Override
    public Enrollment save(Enrollment enrollment) {
        EnrollmentEntity entity = enrollmentJpaRepository.save(EnrollmentMapper.toEntity(enrollment));

        return EnrollmentMapper.toDomain(entity);
    }
}
