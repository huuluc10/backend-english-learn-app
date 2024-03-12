package com.huuluc.englearn;

import com.huuluc.englearn.utils.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EnglearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnglearnApplication.class, args);
    }

}
