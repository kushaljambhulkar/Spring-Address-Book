package com.example.springaddressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringAddressBookApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringAddressBookApplication.class, args);
        log.info("Employee payroll app started in {} Environment " + context.getEnvironment().getProperty("environment"));
        log.info("Employee payroll DB User is {} " + context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
