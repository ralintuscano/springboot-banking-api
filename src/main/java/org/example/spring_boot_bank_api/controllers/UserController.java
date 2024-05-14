package org.example.spring_boot_bank_api.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_boot_bank_api.models.dtos.response.user.UserResponseDTO;
import org.example.spring_boot_bank_api.models.entities.User;
import org.example.spring_boot_bank_api.models.dtos.request.user.UserRequestDTO;
import org.example.spring_boot_bank_api.models.mappers.UserMapper;
import org.example.spring_boot_bank_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bank")
@Slf4j
public class UserController {

    //TODO - API List
    // POST /users - create new user - DONE
    // GET  /users/{userId} - get user by id - DONE
    // PUT /users/{userId} - update user

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> createNewUser(@RequestBody UserRequestDTO createUserRequestDTO){
        User userRequest = userMapper.userRequestDTOtoUser(createUserRequestDTO);
        User user = userService.createAccount(userRequest);
        UserResponseDTO userResponse = userMapper.usertoUserResponseDTO(user);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDTO> getUserDetails(@PathVariable Long userId){
        User user = userService.getUserDetails(userId);

        log.debug("User Entity from Controller: {} Query Accounts {}", user, user.getAccounts());

        UserResponseDTO userResponse = userMapper.usertoUserResponseDTO(user);
        return ResponseEntity.ok(userResponse);
    }

}
