package org.example.spring_boot_bank_api.repository;

import org.example.spring_boot_bank_api.models.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionByAccount_AccountId(Long accountId);
}
