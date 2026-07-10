package pe.tecsup.project.lms.enrollment_service.application.port.outbound;

import pe.tecsup.project.lms.enrollment_service.infrastructure.client.course.requests.FindCourseByIdRequest;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.course.responses.FindCourseByIdResponse;

public interface ExternalCourseClient {

    FindCourseByIdResponse findById(FindCourseByIdRequest request);
}
