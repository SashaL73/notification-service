package aston.intensiv.notificationservice.service;

import aston.intensiv.notificationservice.dto.NotificationMessageDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@EmbeddedKafka(partitions = 1, topics = {"user_notification"})
public class KafkaConsumerServiceIntegrationTest {

    @Autowired
    private KafkaTemplate<Object, NotificationMessageDto> kafkaTemplate;

    @MockBean
    private EmailService emailService;

    @Test
    void testConsumeShouldBeCalledSendEmail() throws InterruptedException {
        NotificationMessageDto messageCreate = NotificationMessageDto.builder()
                .email("test@test.com")
                .operation("CREATE")
                .build();

        kafkaTemplate.send("user_notification", messageCreate);

        Thread.sleep(2000);

        Mockito.verify(emailService).sendEmail("test@test.com", "Здравствуйте! Ваш аккаунт на сайте был успешно создан.");

        NotificationMessageDto messageDelete = NotificationMessageDto.builder()
                .email("test@test.com")
                .operation("DELETE")
                .build();

        kafkaTemplate.send("user_notification", messageDelete);

        Thread.sleep(2000);

        Mockito.verify(emailService).sendEmail("test@test.com", "Здравствуйте! Ваш аккаунт был удалён.");

    }

}
