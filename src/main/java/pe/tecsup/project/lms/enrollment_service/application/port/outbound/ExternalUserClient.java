package pe.tecsup.project.lms.enrollment_service.application.port.outbound;

import pe.tecsup.project.lms.enrollment_service.infrastructure.client.user.requests.FindUserByIdRequest;
import pe.tecsup.project.lms.enrollment_service.infrastructure.client.user.responses.FindUserByIdResponse;

public interface ExternalUserClient {

    FindUserByIdResponse findById(FindUserByIdRequest request);
}
