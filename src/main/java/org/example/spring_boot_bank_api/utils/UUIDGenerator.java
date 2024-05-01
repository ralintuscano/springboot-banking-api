package org.example.spring_boot_bank_api.utils;

import java.util.UUID;

public class UUIDGenerator {
    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
