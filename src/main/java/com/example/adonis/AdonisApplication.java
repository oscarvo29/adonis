package com.example.adonis;

import com.example.adonis.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Collections;

@SpringBootApplication
public class AdonisApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AdonisApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "5050"));
        app.run(args);
    }
}
