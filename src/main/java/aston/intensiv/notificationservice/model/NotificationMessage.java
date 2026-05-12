package aston.intensiv.notificationservice.model;

import aston.intensiv.notificationservice.service.Operation;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class NotificationMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private Operation operation;
}
