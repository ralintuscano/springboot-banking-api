package org.example.spring_boot_bank_api.services;

import jakarta.transaction.Transactional;
import org.example.spring_boot_bank_api.constants.enums.TransactionType;
import org.example.spring_boot_bank_api.exceptions.IllegalWithdrawAmount;
import org.example.spring_boot_bank_api.exceptions.TransactionFailed;
import org.example.spring_boot_bank_api.exceptions.TransactionNotFound;
import org.example.spring_boot_bank_api.models.dtos.request.transaction.TransactionRequestDTO;
import org.example.spring_boot_bank_api.models.entities.Account;
import org.example.spring_boot_bank_api.models.entities.Transaction;
import org.example.spring_boot_bank_api.models.dtos.response.errors.CustomErrorMessage;
import org.example.spring_boot_bank_api.models.mappers.TransactionMapper;
import org.example.spring_boot_bank_api.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionMapper transactionMapper;

    @Transactional
    public Transaction deposit(Transaction transactionRequest) {

        Account account = transactionRequest.getAccount();
        Long currentAccountBalance = account.getAccountBalance();
        Long updatedAccountBalance = Long.sum(currentAccountBalance, transactionRequest.getAmount());
        log.info("Transaction deposited to account prev_balance {} updated balance {}", currentAccountBalance, updatedAccountBalance);

        accountService.updateAccountBalance(account.getAccountId(), updatedAccountBalance);

        log.debug("Transaction deposited to account balance {}", transactionRequest);

        return transactionRepository.save(transactionRequest);
    }

    @Transactional
    public Transaction withdraw(Transaction transactionRequest) {
        Account account = transactionRequest.getAccount();
        Long currentAccountBalance = account.getAccountBalance();

        if(transactionRequest.getAmount() > currentAccountBalance)
            throw new IllegalWithdrawAmount("Transaction amount exceeds current account balance");

        Long updatedAccountBalance = currentAccountBalance - transactionRequest.getAmount();
        accountService.updateAccountBalance(account.getAccountId(), updatedAccountBalance);

        return transactionRepository.save(transactionRequest);
    }

    /*
    * TODO
    *  Rewrite make transfer implementation with good design
    * */

    @Transactional(rollbackOn = TransactionFailed.class )
    public String makeTransfer(TransactionRequestDTO transactionRequestDTO) {

        Long sourceAccountId = transactionRequestDTO.getSourceAccountId();
        Long targetAccountId = transactionRequestDTO.getTargetAccountId();

        Account sourceAccount = accountService.getAccountById(sourceAccountId);
        Account targetAccount = accountService.getAccountById(targetAccountId);

        Transaction debitTransaction = transactionMapper.transactionRequestDtoToTransaction(transactionRequestDTO);
        debitTransaction.setAccount(sourceAccount);
        debitTransaction.setTransactionType(TransactionType.DEBIT);

        Transaction creditTransaction = transactionMapper.transactionRequestDtoToTransaction(transactionRequestDTO);
        creditTransaction.setAccount(targetAccount);
        creditTransaction.setTransactionType(TransactionType.CREDIT);

        this.withdraw(debitTransaction);
        this.deposit(creditTransaction);

        return "Successfully transaction";
    }
    public List<Transaction> getTransactionsByAccountId(Long accountId) {

        Optional<List<Transaction>> transactionList = transactionRepository.findTransactionByAccount_AccountId(accountId);
        if(transactionList.isPresent() && transactionList.get().isEmpty()){
            throw new TransactionNotFound("Transaction(s) Not Found for account id " + accountId);
        }
        return transactionList.get();
    }
}
