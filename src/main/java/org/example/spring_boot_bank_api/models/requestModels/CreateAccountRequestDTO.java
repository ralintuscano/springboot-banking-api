package org.example.spring_boot_bank_api.models.requestModels;

import lombok.Data;
import org.example.spring_boot_bank_api.enums.AccountType;

@Data
public class CreateAccountRequestDTO {
    private AccountType accountType;
    private Long accountBalance;
    private Long userId;
}
