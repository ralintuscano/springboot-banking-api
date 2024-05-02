package org.example.spring_boot_bank_api.models.dtos.request.user;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private String email;
}
