package org.example.ralin_bank_app_demo.models.requestModels;

import lombok.Data;
import org.example.ralin_bank_app_demo.enums.AccountType;

@Data
public class CreateAccountRequestDTO {
    private AccountType accountType;
    private Long accountBalance;
    private Long userId;
}
