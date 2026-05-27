package aston.intensiv.notificationservice.mapper;

import org.springframework.mail.SimpleMailMessage;

public class SimpleMailMessageMapper {
    public static SimpleMailMessage mapToSimpleMailMessage(String email, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText(message);

        return simpleMailMessage;
    }
}
