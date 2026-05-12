package aston.intensiv.notificationservice.service;

import aston.intensiv.notificationservice.dto.EmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final RestTemplate template = new RestTemplate();
    private final JavaMailSender mailSender;

    @Value("${user-service.url}")
    private String path;

    @Override
    public void sendEmail(String email, String message) {

        EmailRequest emailRequest = EmailRequest.builder()
                .email(email)
                .message(message)
                .build();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);

        log.info("отправка сообщения на эндпоинт user-service {}", emailRequest);
        template.postForObject(path, emailRequest, Void.class);
    }
}
