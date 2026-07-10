package pe.tecsup.project.lms.enrollment_service.infrastructure.client.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pe.tecsup.project.lms.enrollment_service.application.port.outbound.ExternalUserClient;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.user.requests.FindUserByIdRequest;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.user.responses.FindUserByIdResponse;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserServiceRestClient implements ExternalUserClient {

    private final RestTemplate restTemplate;

    @Value("${api.base.url.user-api}")
    private String userBaseUrl;

    @Override
    public FindUserByIdResponse findById(FindUserByIdRequest request) {

        String url = this.userBaseUrl + "/api/users/" + request.id;

        try {
            return restTemplate.getForObject(url, FindUserByIdResponse.class);
        } catch (Exception e) {
            log.error("Error calling User Service: {}", e.getMessage());
            throw new RuntimeException("Error calling User Service: " + e.getMessage());
        }
    }
}
