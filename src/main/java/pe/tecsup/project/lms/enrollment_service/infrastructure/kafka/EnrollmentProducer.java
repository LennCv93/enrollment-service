package pe.tecsup.project.lms.enrollment_service.infrastructure.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrollmentProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${enrollment.topic}")
    private String topic;

    public void sendEnrollmentEvent(EnrollmentEvent event) {
        kafkaTemplate.send(topic, event.id().toString(), event);
    }
}
