package org.example.spring_boot_bank_api.repository;

import feign.Param;
import org.example.spring_boot_bank_api.models.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account findAccountByAccountId(Long accountId);
    public List<Account> findAccountsByUser_UserId(Long userId);

    @Modifying
    @Query("UPDATE Account a SET a.accountBalance = ?2 WHERE a.accountId = ?1")
    public void updateAccountBalance(@Param("accountId") Long accountId, @Param("updatedAccountBalance") Long updatedAccountBalance);
}
