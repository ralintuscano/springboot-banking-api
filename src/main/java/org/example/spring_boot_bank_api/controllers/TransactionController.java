package org.example.spring_boot_bank_api.controllers;

import org.example.spring_boot_bank_api.models.dtos.response.transaction.TransactionResponseDTO;
import org.example.spring_boot_bank_api.models.entities.Transaction;
import org.example.spring_boot_bank_api.models.dtos.request.transaction.TransactionRequestDTO;
import org.example.spring_boot_bank_api.models.mappers.TransactionMapper;
import org.example.spring_boot_bank_api.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    TransactionMapper transactionMapper;

    @PostMapping("/transactions/deposit")
    public ResponseEntity<TransactionResponseDTO> deposit(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        log.debug("deposit: Type {} Value {}", transactionRequestDTO.getClass(), transactionRequestDTO);

        Transaction transactionRequest = transactionMapper.transactionRequestDtoToTransaction(transactionRequestDTO);

        Transaction transaction = transactionService.deposit(transactionRequest);

        TransactionResponseDTO transactionResponseDTO = transactionMapper.transactionToTransactionResponseDto(transaction);

        return new ResponseEntity<>(transactionResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/transactions/withdraw")
    public ResponseEntity<TransactionResponseDTO> withdraw(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        Transaction transactionRequest = transactionMapper.transactionRequestDtoToTransaction(transactionRequestDTO);

        Transaction transaction = transactionService.withdraw(transactionRequest);

        TransactionResponseDTO  transactionResponseDTO= transactionMapper.transactionToTransactionResponseDto(transaction);

        return new ResponseEntity<>(transactionResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/transactions/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        String response  =  transactionService.makeTransfer(transactionRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("accounts/{accountId}/transactions")
    public List<TransactionResponseDTO> getTransactionsByAccountId(@PathVariable Long accountId){

        List<Transaction> transactions =  transactionService.getTransactionsByAccountId(accountId);

        List<TransactionResponseDTO> transactionResponseDTOS = transactionMapper.transactionToTransactionResponseDtoList(transactions);

        return transactionResponseDTOS;
    }
}
