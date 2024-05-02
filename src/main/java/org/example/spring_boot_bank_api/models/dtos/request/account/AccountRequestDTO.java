package org.example.spring_boot_bank_api.models.dtos.request.account;

import lombok.Data;
import org.example.spring_boot_bank_api.constants.enums.AccountType;

@Data
public class AccountRequestDTO {
    private AccountType accountType;
    private Long accountBalance;
    private Long userId;
}
