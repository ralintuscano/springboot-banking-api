package org.example.spring_boot_bank_api.aop;


import org.example.spring_boot_bank_api.exceptions.*;
import org.example.spring_boot_bank_api.models.dtos.response.errors.CustomErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e) {
        return "Top Level" + e.getMessage();
    }

    @ExceptionHandler(value = CustomErrorMessage.class)
    public ResponseEntity<String> customExceptionHandler(CustomErrorMessage ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = UserNotFound.class)
    public ResponseEntity<String> userNotFound(UserNotFound ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = UserAlreadyExists.class)
    public ResponseEntity<String> userAlreadyExists(UserAlreadyExists ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = AccountNotFound.class)
    public ResponseEntity<String> accountNotFound(AccountNotFound ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = AccountAlreadyExists.class)
    public ResponseEntity<String> accountAlreadyExists(AccountAlreadyExists ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = NoAccountsFoundForUser.class)
    public ResponseEntity<String> accountsNotFoundForUser(NoAccountsFoundForUser ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = DepositLimitReached.class)
    public ResponseEntity<String> depositLimitReached(DepositLimitReached ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = IllegalWithdrawAmount.class)
    public ResponseEntity<String> illegalWithdrawAmount(IllegalWithdrawAmount ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = TransactionFailed.class)
    public ResponseEntity<String> transactionFailed(TransactionFailed ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = TransactionNotFound.class)
    public ResponseEntity<String> transactionNotFound(TransactionNotFound ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
