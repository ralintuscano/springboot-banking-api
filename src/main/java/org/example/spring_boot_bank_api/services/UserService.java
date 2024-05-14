package org.example.spring_boot_bank_api.services;

import org.example.spring_boot_bank_api.exceptions.UserAlreadyExists;
import org.example.spring_boot_bank_api.exceptions.UserNotFound;
import org.example.spring_boot_bank_api.models.entities.User;
import org.example.spring_boot_bank_api.models.dtos.request.user.UserRequestDTO;
import org.example.spring_boot_bank_api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public User createAccount(User user) {
        if(getUserByEmail(user) != null)
            throw new UserAlreadyExists("User already exists with this email");
        return userRepository.save(user);
    }

    public User getUserDetails(Long userId) {
        log.debug("Retrieving user details for {}", userId);

        User user =  userRepository.findUserByUserId(userId).orElse(null);
        if(user == null) throw new UserNotFound("User not found");
        return user;
    }

    public User getUserByEmail(User user) {
        return userRepository.findUserByEmail(user.getEmail()).orElse(null);
    }
}
