package org.example.spring_boot_bank_api.models.requestModels;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private String name;
    private String email;
}
