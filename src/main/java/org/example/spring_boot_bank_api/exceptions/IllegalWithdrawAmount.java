package org.example.spring_boot_bank_api.exceptions;

public class IllegalWithdrawAmount extends RuntimeException {
    public IllegalWithdrawAmount(String message) {
        super(message);
    }
}
