package aston.intensiv.notificationservice.service;

import aston.intensiv.notificationservice.dto.NotificationMessageDto;
import aston.intensiv.notificationservice.exception.NotFoundException;
import aston.intensiv.notificationservice.mapper.NotificationMessageMapper;
import aston.intensiv.notificationservice.model.NotificationMessage;
import aston.intensiv.notificationservice.repository.NotificationMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NotificationMessageServiceImpl implements NotificationMessageService {

    private final NotificationMessageRepository repository;
    private final EmailService emailService;

    @Override
    @Transactional
    public NotificationMessage addInDbAndSendEmail(NotificationMessageDto request) {

        Operation operation = Operation.operation(request.getOperation()).orElseThrow(
                () -> new NotFoundException("неизвестная операция")
        );

        if (operation.equals(Operation.CREATE)) {
            String sendMessage = "Здравствуйте! Ваш аккаунт на сайте был успешно создан.";
            emailService.sendEmail(request.getEmail(), sendMessage);
            NotificationMessage message = NotificationMessageMapper.mapTpNotificationMessage(request, operation);
            return repository.save(message);

        }

        if (operation.equals(Operation.DELETE)) {
            String sendMessage = "Здравствуйте! Ваш аккаунт был удалён.";
            emailService.sendEmail(request.getEmail(), sendMessage);
            NotificationMessage message = NotificationMessageMapper.mapTpNotificationMessage(request, operation);
            return repository.save(message);
        }

        return null;

    }
}