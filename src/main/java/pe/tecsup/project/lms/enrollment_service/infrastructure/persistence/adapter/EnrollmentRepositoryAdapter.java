package pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;
import pe.tecsup.project.lms.enrollment_service.domain.repository.EnrollmentRepository;
import pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.entity.EnrollmentEntity;
import pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.mapper.EnrollmentMapper;
import pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.repository.EnrollmentJpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EnrollmentRepositoryAdapter implements EnrollmentRepository {

    public final EnrollmentJpaRepository enrollmentJpaRepository;

    @Override
    public Enrollment save(Enrollment enrollment) {
        EnrollmentEntity entity = enrollmentJpaRepository.save(EnrollmentMapper.toEntity(enrollment));

        return EnrollmentMapper.toDomain(entity);
    }

    @Override
    public Enrollment findById(Long id) {
        Optional<EnrollmentEntity> entity = enrollmentJpaRepository.findById(id);

        if (entity.isEmpty()) throw new IllegalArgumentException("Enrollment " + id + "not found");

        return EnrollmentMapper.toDomain(entity.get());
    }

    @Override
    public Enrollment update(Long id, String status) {
        Optional<EnrollmentEntity> entity = enrollmentJpaRepository.findById(id);

        if (entity.isEmpty()) throw new IllegalArgumentException("Enrollment " + id + "not found");

        EnrollmentEntity enrollmentEntity = entity.get();
        enrollmentEntity.status = status;
        enrollmentEntity.updatedAt = LocalDateTime.now();

        EnrollmentEntity entityUpdated = enrollmentJpaRepository.save(enrollmentEntity);

        return EnrollmentMapper.toDomain(entityUpdated);
    }
}
