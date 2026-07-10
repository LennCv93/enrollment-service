package pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.mapper;

import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;
import pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.entity.EnrollmentEntity;

public class EnrollmentMapper {

    public static EnrollmentEntity toEntity(Enrollment enrollment) {
        return EnrollmentEntity.builder()
                .userId(enrollment.userId)
                .courseId(enrollment.courseId)
                .status(enrollment.status)
                .createdAt(enrollment.createdAt)
                .updatedAt(enrollment.updatedAt)
                .build();
    }

    public static Enrollment toDomain(EnrollmentEntity entity) {
        return Enrollment.builder()
                .id(entity.id)
                .userId(entity.userId)
                .courseId(entity.courseId)
                .status(entity.status)
                .createdAt(entity.createdAt)
                .updatedAt(entity.updatedAt)
                .build();
    }
}
