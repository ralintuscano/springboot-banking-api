package org.example.spring_boot_bank_api.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_boot_bank_api.models.entities.User;
import org.example.spring_boot_bank_api.models.requestModels.CreateUserRequestDTO;
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
    // POST /users - create new user
    // GET  /users/{userId} - get user by id
    // PUT /users/{userId} - update user

    @Autowired
    UserService userService;

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createNewUser(@RequestBody CreateUserRequestDTO createUserRequestDTO){
//        log.info("Create new user request: {}", createUserRequestDTO);
        User user = userService.createAccount(createUserRequestDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable Long userId){

        User user = userService.getUserDetails(userId);
        return ResponseEntity.ok(user);
    }

}
