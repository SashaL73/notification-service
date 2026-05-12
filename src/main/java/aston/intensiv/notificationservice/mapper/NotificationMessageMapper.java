package aston.intensiv.notificationservice.mapper;

import aston.intensiv.notificationservice.dto.NotificationMessageDto;
import aston.intensiv.notificationservice.model.NotificationMessage;
import aston.intensiv.notificationservice.service.Operation;

public class NotificationMessageMapper {

    public static NotificationMessage mapTpNotificationMessage(NotificationMessageDto request, Operation op) {
        return NotificationMessage.builder()
                .email(request.getEmail())
                .operation(op)
                .build();
    }
}
