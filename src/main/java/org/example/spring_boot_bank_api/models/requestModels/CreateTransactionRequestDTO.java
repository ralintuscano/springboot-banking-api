package org.example.spring_boot_bank_api.models.requestModels;

import lombok.Data;
import org.example.spring_boot_bank_api.enums.TransactionType;

@Data
public class CreateTransactionRequestDTO {
    private Long amount;
    private TransactionType transactionType;
    private Long accountId;
}
