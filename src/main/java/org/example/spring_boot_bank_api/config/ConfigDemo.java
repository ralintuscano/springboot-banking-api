package org.example.spring_boot_bank_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
@EnableAsync
public class ConfigDemo {

    @Scheduled(fixedRate = 1000)
//    @Async
    public void printNumberOne() throws InterruptedException {
        System.out.println("Printing number 1"+ System.currentTimeMillis() / 1000 + " "+ Thread.currentThread().getName());
        Thread.sleep(6000);
    }

    @Scheduled(fixedRate = 1000)
//    @Async
    public void printNumberTwo() throws InterruptedException {
        System.out.println("Printing number 2"+ System.currentTimeMillis() / 1000 + " "+ Thread.currentThread().getName());
        Thread.sleep(6000);
    }


    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        return threadPoolTaskScheduler;
    }

}
