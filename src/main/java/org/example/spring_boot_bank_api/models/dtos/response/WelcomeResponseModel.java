package org.example.spring_boot_bank_api.models.dtos.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WelcomeResponseModel {
    private String message;
}
