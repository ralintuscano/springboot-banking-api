package org.example.spring_boot_bank_api.models.mappers;

import org.example.spring_boot_bank_api.models.dtos.request.transaction.TransactionRequestDTO;
import org.example.spring_boot_bank_api.models.dtos.request.transaction.TransactionResponseDTO;
import org.example.spring_boot_bank_api.models.entities.Account;
import org.example.spring_boot_bank_api.models.entities.Transaction;
import org.example.spring_boot_bank_api.services.AccountService;
import org.mapstruct.*;
import java.util.List;

/**
 * TODO
 * Optimize mapper to support sourceAccountId/targetAccountId
 * Currently bloated code in the service handler
 */


@Mapper(componentModel = "spring", uses = {AccountService.class})
public interface TransactionMapper {

    @Mapping(target = "transactionId", ignore = true)
    @Mapping(source = "accountId", target = "account")
    public Transaction transactionRequestDtoToTransaction(TransactionRequestDTO transactionRequestDTO);

//    @Mapping(target = "transactionId", ignore = true)
//    @Mapping(
//            target = "account",
//            expression = "java(getAccountByTransactionType(transactionRequestDTO, transactionType))"
//    )
//    @Mapping(source = "transactionRequestDTO.accountId", target = "account")
//    @Mapping(target = "account", source = "transactionRequestDTO.sourceAccountId", conditionExpression = "java(transactionType == TransactionType.DEBIT )" , ignore = true)
//    @Mapping(target = "account", source = "transactionRequestDTO.targetAccountId", conditionExpression = "java(transactionType == TransactionType.CREDIT )", conditionQualifiedBy = )
//    public Transaction transactionRequestDtoToTransaction(TransactionRequestDTO transactionRequestDTO, TransactionType transactionType);

    @Mapping(source = "account", target = "accountId")
    public TransactionResponseDTO transactionToTransactionResponseDto(Transaction transaction);

    public List<TransactionResponseDTO> transactionToTransactionResponseDtoList(List<Transaction> transactions);

    default Long map(Account account){
        return  account.getAccountId();
    }

    default Account getAccount(Account account){
        return account;
    }

}
