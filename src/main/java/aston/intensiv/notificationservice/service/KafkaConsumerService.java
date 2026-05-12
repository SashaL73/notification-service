package aston.intensiv.notificationservice.service;

import aston.intensiv.notificationservice.dto.NotificationMessageDto;

public interface KafkaConsumerService {

    public void consume(NotificationMessageDto message);
}
