package org.example.spring_boot_bank_api.exceptions;

public class TransactionNotFound extends RuntimeException {
    public TransactionNotFound(String message) {
        super(message);
    }
}
