package org.example.ralin_bank_app_demo.models.responseModels;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

//@Component
@Data
@Builder
public class CustomMetaDataDTO {
    private HttpStatus errorCode;
    private HttpStatus code;
    private String message;
}
