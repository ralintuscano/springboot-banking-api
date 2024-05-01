package org.example.spring_boot_bank_api.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class WelcomeTest {
    @Test
    void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected(){
        Optional<String> opt = Optional.of("MyProject");

        Assertions.assertFalse(opt.isEmpty());

    }

    @Test
    void givenAnOptional_whenIfPresentWorks_theIsCorrect(){
        Optional<String> opt = Optional.of("MyOtherProject");
        opt.ifPresent(x -> System.out.println(x.length()));
    }
}