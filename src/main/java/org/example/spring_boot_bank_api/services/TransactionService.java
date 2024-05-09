package org.example.spring_boot_bank_api.services;

import jakarta.transaction.Transactional;
import org.example.spring_boot_bank_api.models.entities.Account;
import org.example.spring_boot_bank_api.models.entities.Transaction;
import org.example.spring_boot_bank_api.models.dtos.request.transaction.TransactionRequestDTO;
import org.example.spring_boot_bank_api.models.dtos.response.errors.CustomErrorMessage;
import org.example.spring_boot_bank_api.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;

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

        if(transactionRequest.getAmount() > currentAccountBalance) {
            throw new CustomErrorMessage("Transaction amount exceeds current account balance");
        }

        Long updatedAccountBalance = currentAccountBalance - transactionRequest.getAmount();

        accountService.updateAccountBalance(account.getAccountId(), updatedAccountBalance);

        return transactionRepository.save(transactionRequest);
    }

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findTransactionByAccount_AccountId(accountId);
    }
}
