package com.example.adonis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class AdonisApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AdonisApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "5050"));
        app.setDefaultProperties(Collections.singletonMap("spring.datasource.url", "jdbc:mysql://192.168.0.11/adonis"));
        app.setDefaultProperties(Collections.singletonMap("spring.datasource.username", "4918Demk!"));
        app.setDefaultProperties(Collections.singletonMap("spring.jpa.generate-ddl", "true"));
        app.setDefaultProperties(Collections.singletonMap("spring.jpa.hibernate.ddl-auto", "create-drop "));
        app.setDefaultProperties(Collections.singletonMap("spring.sql.init.mode", "always"));
        app.run(args);
    }
}


