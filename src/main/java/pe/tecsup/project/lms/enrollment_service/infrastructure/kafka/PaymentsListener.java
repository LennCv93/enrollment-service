package pe.tecsup.project.lms.enrollment_service.infrastructure.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pe.tecsup.project.lms.enrollment_service.application.usecases.UpdateEnrollmentUseCase;
import pe.tecsup.project.lms.enrollment_service.domain.model.Enrollment;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentsListener {

    public final UpdateEnrollmentUseCase updateEnrollmentUseCase;
    public final EnrollmentProducer enrollmentProducer;

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "payments", groupId = "enrollment-service-group")
    public void listen(String message) {
        log.info("Mensaje recibido del topic 'payments': {}", message);

        try {
            JsonNode json = objectMapper.readTree(message);

            Long enrollmentId = json.get("enrollmentId").asLong();
            String status = json.get("status").asText();

            String newStatus = "";

            if (status.equals("APPROVED")) {
                newStatus = "CONFIRMED";
            } else {
                newStatus = "CANCELLED";
            }

            Enrollment enrollmentUpdated = updateEnrollmentUseCase.execute(enrollmentId, newStatus);

            EnrollmentEvent event = new EnrollmentEvent(
                    KafkaEvents.ENROLLMENT_UPDATED_EVENT.name(),
                    enrollmentUpdated.id,
                    enrollmentUpdated.userId,
                    enrollmentUpdated.courseId,
                    enrollmentUpdated.status,
                    enrollmentUpdated.userName,
                    enrollmentUpdated.courseName,
                    enrollmentUpdated.instructorName,
                    new Date().getTime()
            );

            enrollmentProducer.sendEnrollmentEvent(event);

        } catch (Exception ex) {
            log.info("Error al intentar leer topic 'payments': {}", ex.getMessage());
        }
    }
}
