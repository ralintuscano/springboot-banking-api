package org.example.spring_boot_bank_api.exceptions;

public class DepositLimitReached extends RuntimeException {
    public DepositLimitReached(String message) {
        super(message);
    }
}
