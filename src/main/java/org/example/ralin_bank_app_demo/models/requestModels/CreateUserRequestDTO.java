package org.example.ralin_bank_app_demo.models.requestModels;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private String name;
    private String email;
}
