package org.example.spring_boot_bank_api.controllers;

import org.example.spring_boot_bank_api.models.dtos.request.account.AccountResponseDTO;
import org.example.spring_boot_bank_api.models.entities.Account;
import org.example.spring_boot_bank_api.models.dtos.request.account.AccountRequestDTO;
import org.example.spring_boot_bank_api.models.mappers.AccountMapper;
import org.example.spring_boot_bank_api.services.AccountService;
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

    /**
     * POST /users/{userId}/accounts - create a new account for user
     * GET  /users/{userId}/accounts - get all user accounts
     * GET  /accounts/{accountId} - get account by id
     * PUT  /users/{userId}/accounts - update account details
     */

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountMapper accountMapper;

    @PostMapping(value = "/accounts")
    public ResponseEntity<AccountResponseDTO> createNewAccount(@RequestBody AccountRequestDTO createAccountRequestDTO){

        Account accountRequest = accountMapper.accountRequestDtoToAccount(createAccountRequestDTO);

        Account account = accountService.createNewAccount(accountRequest);

        AccountResponseDTO accountResponseDTO = accountMapper.accountToAccountResponseDTO(account);

        return ResponseEntity.ok(accountResponseDTO);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<AccountResponseDTO> getAccountById(@PathVariable Long accountId){
        log.info("Controller - Getting account by id: {}", accountId);

        Account account =  accountService.getAccountById(accountId);

        AccountResponseDTO accountResponseDTO = accountMapper.accountToAccountResponseDTO(account);

        return ResponseEntity.ok(accountResponseDTO);
    }

    @GetMapping("users/{userId}/accounts")
    public ResponseEntity<List<AccountResponseDTO>> getAccountsForUser(@PathVariable Long userId){

        log.info("Controller - Getting accounts for user: {}", userId);

        List<Account> accounts =  accountService.getAccountsForUserByUserId(userId);

        List<AccountResponseDTO> accountResponseDTOList = accountMapper.accountToAccountResponseDTO(accounts);

        return ResponseEntity.ok(accountResponseDTOList);
    }


}
