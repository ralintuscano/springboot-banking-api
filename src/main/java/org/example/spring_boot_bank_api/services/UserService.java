package org.example.spring_boot_bank_api.services;

import org.example.spring_boot_bank_api.models.entities.User;
import org.example.spring_boot_bank_api.models.requestModels.CreateUserRequestDTO;
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

    public User createAccount(CreateUserRequestDTO createUserRequestDTO) {
        User user = new User();
        user.setName(createUserRequestDTO.getName());
        user.setEmail(createUserRequestDTO.getEmail());
        return userRepository.save(user);
    }

    public User getUserDetails(Long userId) {
        log.debug("Retrieving user details for {}", userId);
        return userRepository.findUserByUserId(userId).orElse(null);
    }
}
