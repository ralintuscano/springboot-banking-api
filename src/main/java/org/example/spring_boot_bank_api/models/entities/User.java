package org.example.spring_boot_bank_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String name;
    private String email;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    Set<Account> accounts;

}

