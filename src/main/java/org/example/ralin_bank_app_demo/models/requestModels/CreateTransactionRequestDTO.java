package org.example.ralin_bank_app_demo.models.requestModels;

import lombok.Data;
import org.example.ralin_bank_app_demo.enums.TransactionType;

@Data
public class CreateTransactionRequestDTO {
    private Long amount;
    private TransactionType transactionType;
    private Long accountId;
}
