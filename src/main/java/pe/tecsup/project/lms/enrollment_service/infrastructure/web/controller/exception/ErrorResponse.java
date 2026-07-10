package pe.tecsup.project.lms.enrollment_service.infrastructure.web.controller.exception;

public record ErrorResponse(int status, String message, long timestamp){}
