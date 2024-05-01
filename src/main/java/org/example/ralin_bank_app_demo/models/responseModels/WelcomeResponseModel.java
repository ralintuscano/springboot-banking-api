package org.example.ralin_bank_app_demo.models.responseModels;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WelcomeResponseModel {
    private String message;
}
