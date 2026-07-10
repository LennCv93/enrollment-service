package pe.tecsup.project.lms.enrollment_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    public Long id;
    public Long userId;
    public String userName;
    public Long courseId;
    public String courseName;
    public String instructorName;
    public String status;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public static Enrollment create(Long userId, Long courseId, String status) {
        if (userId == null || userId == 0) throw new IllegalArgumentException("user id is required");

        if (courseId == null || courseId == 0) throw new IllegalArgumentException("course id is required");

        Enrollment enrollment = new Enrollment();
        enrollment.userId = userId;
        enrollment.courseId = courseId;
        enrollment.status = status;
        enrollment.createdAt = LocalDateTime.now();
        enrollment.updatedAt = LocalDateTime.now();

        return enrollment;
    }
}
