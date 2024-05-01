package org.example.ralin_bank_app_demo.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.example.ralin_bank_app_demo.enums.TransactionType;

@Entity
@Table( name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Long amount;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

}
