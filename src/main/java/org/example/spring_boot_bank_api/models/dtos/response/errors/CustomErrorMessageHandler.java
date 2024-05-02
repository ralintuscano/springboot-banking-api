package org.example.spring_boot_bank_api.models.dtos.response.errors;

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
