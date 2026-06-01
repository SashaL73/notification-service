package aston.intensiv.notificationservice.controller;

import aston.intensiv.notificationservice.dto.NotificationMessageDto;
import aston.intensiv.notificationservice.service.NotificationMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationMessageService notificationMessageService;

    @PostMapping("/email")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendEmail(@Valid @RequestBody NotificationMessageDto request) {
        log.info("Получено сообщение по rest request={}", request);
        notificationMessageService.addInDbAndSendEmail(request);
    }
}
