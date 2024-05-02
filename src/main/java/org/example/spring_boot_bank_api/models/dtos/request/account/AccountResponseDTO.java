package org.example.spring_boot_bank_api.models.dtos.request.account;

import lombok.Data;
import org.example.spring_boot_bank_api.constants.enums.AccountType;

@Data
public class AccountResponseDTO {
    private Long accountId;
    private String accountNumber;
    private Long accountBalance;
    private AccountType accountType;
    private Long userId;
}
