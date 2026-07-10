package pe.tecsup.project.lms.enrollment_service.infrastructure.client.user.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FindUserByIdResponse {
    public Long id;
    public String email;
    public String firstName;
    public String lastName;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
