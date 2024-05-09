package org.example.spring_boot_bank_api.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.example.spring_boot_bank_api.constants.enums.AccountType;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long accountId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String accountNumber;

    private Long accountBalance;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
//    @JsonBackReference
    private User user;

//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//    private List<Transaction> transactions;
}
