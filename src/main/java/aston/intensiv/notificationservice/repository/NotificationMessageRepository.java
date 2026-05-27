package aston.intensiv.notificationservice.repository;

import aston.intensiv.notificationservice.model.NotificationMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationMessageRepository extends JpaRepository<NotificationMessage, Long> {

}
