package pe.tecsup.project.lms.enrollment_service.infrastructure.kafka;

public record EnrollmentEvent(
        String event,
        Long id,
        Long userId,
        Long courseId,
        String status,
        String userName,
        String courseName,
        String instructorName,
        Long timestamp
) {
}
