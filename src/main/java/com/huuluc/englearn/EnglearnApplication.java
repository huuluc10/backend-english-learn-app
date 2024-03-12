package com.huuluc.englearn;

import com.huuluc.englearn.utils.StorageProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@OpenAPIDefinition(info = @Info(title = "Englearn API", version = "1.0",
        description = "Documentation Englearn API v1.0", contact = @Contact(name = "Nguyễn Hữu Lực",
        email = "lucnguyenhuu91@gmail.com")))
public class EnglearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnglearnApplication.class, args);
    }

}
