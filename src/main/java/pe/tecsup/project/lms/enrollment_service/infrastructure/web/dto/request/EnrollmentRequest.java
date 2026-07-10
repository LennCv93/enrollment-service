package pe.tecsup.project.lms.enrollment_service.infrastructure.web.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EnrollmentRequest {
    public Long userId;
    public Long courseId;
}
