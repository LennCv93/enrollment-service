package pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.tecsup.project.lms.enrollment_service.infrastructure.persistence.entity.EnrollmentEntity;

public interface EnrollmentJpaRepository extends JpaRepository<EnrollmentEntity, Long>{}
