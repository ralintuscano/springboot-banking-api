package org.example.spring_boot_bank_api;

import org.example.spring_boot_bank_api.aop.AopDemo;
import org.example.spring_boot_bank_api.config.ConfigDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {ConfigDemo.class, AopDemo.class})})
public class JavaSpringBootBankDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootBankDemoApplication.class, args);
    }

}
