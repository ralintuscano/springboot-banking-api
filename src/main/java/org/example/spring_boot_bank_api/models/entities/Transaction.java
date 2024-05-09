package org.example.spring_boot_bank_api.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.example.spring_boot_bank_api.constants.enums.TransactionType;

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
//    @JsonBackReference
    private Account account;

}
