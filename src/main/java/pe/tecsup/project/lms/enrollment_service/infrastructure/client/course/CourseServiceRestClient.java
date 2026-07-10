package pe.tecsup.project.lms.enrollment_service.infrastructure.client.course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pe.tecsup.project.lms.enrollment_service.application.port.outbound.ExternalCourseClient;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.course.requests.FindCourseByIdRequest;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.course.responses.FindCourseByIdResponse;

@Component
@RequiredArgsConstructor
@Slf4j
public class CourseServiceRestClient implements ExternalCourseClient {

    private final RestTemplate restTemplate;

    @Value("${api.base.url.course-api}")
    private String courseBaseUrl;

    @Override
    public FindCourseByIdResponse findById(FindCourseByIdRequest request) {
        String url = this.courseBaseUrl + "/api/courses/" + request.id;

        try {
            return restTemplate.getForObject(url, FindCourseByIdResponse.class);
        } catch (Exception e) {
            log.error("Error calling Course Service: {}", e.getMessage());
            throw new RuntimeException("Error calling Course Service: " + e.getMessage());
        }
    }
}
