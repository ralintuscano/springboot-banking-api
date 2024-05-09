package org.example.spring_boot_bank_api.models.mappers;

import org.example.spring_boot_bank_api.models.dtos.request.transaction.TransactionRequestDTO;
import org.example.spring_boot_bank_api.models.dtos.request.transaction.TransactionResponseDTO;
import org.example.spring_boot_bank_api.models.entities.Account;
import org.example.spring_boot_bank_api.models.entities.Transaction;
import org.example.spring_boot_bank_api.services.AccountService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AccountService.class})
public interface TransactionMapper {
    @Mapping(target = "transactionId", ignore = true)
    @Mapping(source = "accountId", target = "account")
    public Transaction transactionRequestDtoToTransaction(TransactionRequestDTO transactionRequestDTO);

    @Mapping(source = "account", target = "accountId")
    public TransactionResponseDTO transactionToTransactionResponseDto(Transaction transaction);

    public List<TransactionResponseDTO> transactionToTransactionResponseDtoList(List<Transaction> transactions);

    default Long map(Account account){
        return  account.getAccountId();
    }
}
