package org.example.ralin_bank_app_demo;

import org.example.ralin_bank_app_demo.aop.AopDemo;
import org.example.ralin_bank_app_demo.config.ConfigDemo;
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
