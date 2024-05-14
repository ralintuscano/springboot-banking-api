package org.example.spring_boot_bank_api.exceptions;

public class TransactionFailed extends RuntimeException {
    public TransactionFailed(String message) {
        super(message);
    }
}
