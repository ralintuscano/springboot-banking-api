package org.example.ralin_bank_app_demo.models.responseModels;

import lombok.Data;


@Data
//@AllArgsConstructor
public class CustomErrorMessage extends RuntimeException {
//    private HttpStatus httpStatus;
    private String message;
//    private String error;

    public CustomErrorMessage(String message){
        super(message);
        this.message = message;
    }
}
