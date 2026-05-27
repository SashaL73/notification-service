package aston.intensiv.notificationservice.service;

import aston.intensiv.notificationservice.mapper.SimpleMailMessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender mailSender;


    @Override
    public void sendEmail(String email, String message) {
        mailSender.send(SimpleMailMessageMapper.mapToSimpleMailMessage(
                email, message
        ));

    }
}
