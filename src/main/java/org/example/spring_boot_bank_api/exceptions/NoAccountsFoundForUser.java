package org.example.spring_boot_bank_api.exceptions;

public class NoAccountsFoundForUser extends RuntimeException {
    public NoAccountsFoundForUser(String message) {}
}
