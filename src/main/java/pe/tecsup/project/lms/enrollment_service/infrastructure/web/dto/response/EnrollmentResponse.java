package pe.tecsup.project.lms.enrollment_service.infrastructure.web.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class EnrollmentResponse {
    public Long id;
    public Long userId;
    public String userName;
    public Long courseId;
    public String courseName;
    public String instructorName;
    public String status;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
