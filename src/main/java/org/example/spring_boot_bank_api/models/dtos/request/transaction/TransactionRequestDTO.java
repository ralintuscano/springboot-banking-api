package org.example.spring_boot_bank_api.models.dtos.request.transaction;

import lombok.Data;
import org.example.spring_boot_bank_api.constants.enums.TransactionType;

@Data
public class TransactionRequestDTO {
    private Long amount;
    private TransactionType transactionType;
    private Long accountId;
}
