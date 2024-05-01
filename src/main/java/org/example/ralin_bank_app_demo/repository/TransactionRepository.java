package org.example.ralin_bank_app_demo.repository;

import org.example.ralin_bank_app_demo.models.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionByAccount_AccountId(Long accountId);
}
