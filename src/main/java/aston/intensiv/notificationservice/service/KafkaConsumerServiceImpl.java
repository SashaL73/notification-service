package aston.intensiv.notificationservice.service;

import aston.intensiv.notificationservice.dto.NotificationMessageDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService{

    private final NotificationMessageService notificationMessageService;

    @Override
    @KafkaListener(topics = "${app.kafka.topics.user-notification}")
    public void consume(@Valid NotificationMessageDto message) {
        notificationMessageService.addInDbAndSendEmail(message);
    }
}
