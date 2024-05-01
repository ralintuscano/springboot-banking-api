package org.example.ralin_bank_app_demo.controllers;

import org.example.ralin_bank_app_demo.models.entities.Account;
import org.example.ralin_bank_app_demo.models.requestModels.CreateAccountRequestDTO;
import org.example.ralin_bank_app_demo.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank")
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    //TODO - API Structures
    // POST /users/{userId}/accounts - create a new account for user
    // GET  /users/{userId}/accounts - get all user accounts
    // GET  /accounts/{accountId} - get account by id
    // PUT  /users/{userId}/accounts - update account details

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/accounts")
    public ResponseEntity<Account> createNewAccount(@RequestBody CreateAccountRequestDTO createAccountRequestDTO){
        Account account = accountService.createNewAccount(createAccountRequestDTO);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/accounts/{accountId}")
    public Account getAccountById(@PathVariable Long accountId){
        log.info("Controller - Getting account by id: {}", accountId);
        return accountService.getAccountById(accountId);
    }

    @GetMapping("users/{userId}/accounts")
    public List<Account> getAccountsForUser(@PathVariable Long userId){
        log.info("Controller - Getting accounts for user: {}", userId);
        return accountService.getAccountsForUserByUserId(userId);
    }


}
