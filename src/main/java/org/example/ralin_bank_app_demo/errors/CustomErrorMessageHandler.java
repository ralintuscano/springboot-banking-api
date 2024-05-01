package org.example.ralin_bank_app_demo.errors;

import org.example.ralin_bank_app_demo.models.responseModels.CustomErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorMessageHandler {

    @ExceptionHandler(value = {CustomErrorMessage.class})
    public ResponseEntity<Object> errorHandlerTest(CustomErrorMessage ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex);
    }

}
