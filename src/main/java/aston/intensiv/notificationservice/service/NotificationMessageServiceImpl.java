package aston.intensiv.notificationservice.service;

import aston.intensiv.notificationservice.dto.NotificationMessageDto;
import aston.intensiv.notificationservice.mapper.NotificationMessageMapper;
import aston.intensiv.notificationservice.model.NotificationMessage;
import aston.intensiv.notificationservice.repository.NotificationMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationMessageServiceImpl implements NotificationMessageService{

    private final NotificationMessageRepository repository;

    @Override
    public NotificationMessage addInDb(NotificationMessageDto request, Operation operation) {
        NotificationMessage message = NotificationMessageMapper.mapTpNotificationMessage(request, operation);
        return repository.save(message);

    }
}
