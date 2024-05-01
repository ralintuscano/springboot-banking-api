package org.example.spring_boot_bank_api.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopDemo {

    @Before(value = "execution(* org.example.spring_boot_bank_api.controllers..*(..))")
    public void loggingAdvice(JoinPoint joinPoint){
        System.out.println("Before loggingAdvice " + joinPoint);
    }

}
