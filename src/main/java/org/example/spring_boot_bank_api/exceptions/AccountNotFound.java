package org.example.spring_boot_bank_api.exceptions;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(String message) {
        super(message);
    }
}
