package org.example.ralin_bank_app_demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopDemo {

    @Before(value = "execution(* org.example.ralin_bank_app_demo.controllers..*(..))")
    public void loggingAdvice(JoinPoint joinPoint){
        System.out.println("Before loggingAdvice " + joinPoint);
    }

}
