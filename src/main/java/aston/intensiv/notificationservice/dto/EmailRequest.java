package aston.intensiv.notificationservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequest {
    @Email
    private String email;
    @NotBlank
    private String message;
}
