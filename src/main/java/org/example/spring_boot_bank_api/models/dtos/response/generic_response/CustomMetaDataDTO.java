package org.example.spring_boot_bank_api.models.dtos.response.generic_response;

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
