package com.huuluc.englearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EnglearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnglearnApplication.class, args);
    }

}
