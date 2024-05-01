package org.example.ralin_bank_app_demo.repository;

import org.example.ralin_bank_app_demo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserByUserId(Long userId);
}
