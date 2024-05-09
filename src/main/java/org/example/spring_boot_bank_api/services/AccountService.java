package org.example.spring_boot_bank_api.services;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_boot_bank_api.models.dtos.request.account.AccountResponseDTO;
import org.example.spring_boot_bank_api.models.entities.Account;
import org.example.spring_boot_bank_api.models.entities.User;
import org.example.spring_boot_bank_api.models.dtos.request.account.AccountRequestDTO;
import org.example.spring_boot_bank_api.models.dtos.response.errors.CustomErrorMessage;
import org.example.spring_boot_bank_api.models.mappers.AccountMapper;
import org.example.spring_boot_bank_api.repository.AccountRepository;
import org.example.spring_boot_bank_api.repository.UserRepository;
import org.example.spring_boot_bank_api.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;

    /**TODO
     * Find out how to include userId in the response
     * Currently only account is returned, no related entities
     */

    public Account createNewAccount(Account accountRequest) {

        accountRequest.setAccountNumber(UUIDGenerator.generateUUID());

        log.debug("SERVICE Before Create new account Account Entity {}", accountRequest);

        return accountRepository.save(accountRequest);
    }

    public Account getAccountById(Long accountId) {
        log.info("Service - Retrieving account {}", accountId);
        return accountRepository.findAccountByAccountId(accountId);
    }

    public List<Account> getAccountsForUserByUserId(Long userId){
        log.info("Service - Retrieving accounts for user {}", userId);
        return accountRepository.findAccountsByUser_UserId(userId);
    }

    public void updateAccountBalance(Long accountId, Long updatedAccountBalance) {
        log.debug("Service - Updating account balance {} for account {}", updatedAccountBalance, accountId);
        accountRepository.updateAccountBalance(accountId, updatedAccountBalance);
    }
}
