package org.example.spring_boot_bank_api.repository;

import org.example.spring_boot_bank_api.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserByUserId(Long userId);
}
