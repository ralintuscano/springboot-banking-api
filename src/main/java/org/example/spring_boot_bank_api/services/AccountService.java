package org.example.spring_boot_bank_api.services;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_boot_bank_api.exceptions.AccountAlreadyExists;
import org.example.spring_boot_bank_api.exceptions.AccountNotFound;
import org.example.spring_boot_bank_api.exceptions.NoAccountsFoundForUser;
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

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

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

        List<Account> userAccounts = this.getAccountsForUserByUserId(accountRequest.getUser().getUserId());

        boolean accountAlreadyExists = userAccounts
                .stream()
                .anyMatch(x -> x.getAccountType() == accountRequest.getAccountType());

        if (accountAlreadyExists) {
            throw new AccountAlreadyExists("Account already exists with this type: " + accountRequest.getAccountType());
        }

        accountRequest.setAccountNumber(UUIDGenerator.generateUUID());

        log.debug("SERVICE Before Create new account Account Entity {}", accountRequest);

        return accountRepository.save(accountRequest);
    }

    public Account getAccountById(Long accountId) {
        log.info("Service - Retrieving account {}", accountId);
        Optional<Account> account = accountRepository.findAccountByAccountId(accountId);
        return account.orElseThrow(() -> new AccountNotFound("Account not found for id " + accountId));
    }

    public List<Account> getAccountsForUserByUserId(Long userId){
        log.info("Service - Retrieving accounts for user {}", userId);

        Optional<List<Account>> userAccounts =  accountRepository.findAccountsByUser_UserId(userId);
        return userAccounts.orElseThrow(() -> new NoAccountsFoundForUser("Account not found for user " + userId));
    }

    public void updateAccountBalance(Long accountId, Long updatedAccountBalance) {
        log.debug("Service - Updating account balance {} for account {}", updatedAccountBalance, accountId);

        Optional<Account> account = accountRepository.findAccountByAccountId(accountId);
        if (account.isEmpty()){
            throw new AccountNotFound("Account not found for id " + accountId);
        }

        accountRepository.updateAccountBalance(accountId, updatedAccountBalance);
    }
}
