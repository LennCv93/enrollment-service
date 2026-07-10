package pe.tecsup.project.lms.enrollment_service.infrastructure.client.course.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FindCourseByIdResponse {
    public Long id;
    public String name;
    public String instructor;
    public String status;
    public BigDecimal price;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
