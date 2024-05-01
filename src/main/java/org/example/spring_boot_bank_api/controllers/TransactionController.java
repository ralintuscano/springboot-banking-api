package org.example.spring_boot_bank_api.controllers;

import org.example.spring_boot_bank_api.models.entities.Transaction;
import org.example.spring_boot_bank_api.models.requestModels.CreateTransactionRequestDTO;
import org.example.spring_boot_bank_api.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank")
public class TransactionController {
    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    //TODO - API List
    // POST /transactions/ - create a transaction
    // GET /transactions/{transactionId} - get transactions by Id
    // GET /transactions/ - get all transactions for user
    // GET /transactions/

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions/deposit")
    public <T> CreateTransactionRequestDTO deposit(@RequestBody CreateTransactionRequestDTO createTransactionRequestDTO) {
        log.debug("deposit: Type {} Value {}", createTransactionRequestDTO.getClass(), createTransactionRequestDTO);
        transactionService.deposit(createTransactionRequestDTO);
        return createTransactionRequestDTO;
    }

    @PostMapping("/transactions/withdraw")
    public CreateTransactionRequestDTO withdraw(@RequestBody CreateTransactionRequestDTO createTransactionRequestDTO) {
        transactionService.withdraw(createTransactionRequestDTO);
        return createTransactionRequestDTO;
    }
//
//    @PostMapping("/transactions/from/{from_accountId}/to/{to_accountId}")
//    public Transaction transfer(@PathVariable Long from_accountId,@PathVariable Long to_accountId) {}

    @GetMapping("accounts/{accountId}/transactions")
    public List<Transaction> getTransactionsByAccountId(@PathVariable Long accountId){
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
