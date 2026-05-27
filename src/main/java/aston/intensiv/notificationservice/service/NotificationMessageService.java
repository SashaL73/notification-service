package aston.intensiv.notificationservice.service;

import aston.intensiv.notificationservice.dto.NotificationMessageDto;
import aston.intensiv.notificationservice.model.NotificationMessage;

public interface NotificationMessageService {
    NotificationMessage addInDbAndSendEmail(NotificationMessageDto request);
}
