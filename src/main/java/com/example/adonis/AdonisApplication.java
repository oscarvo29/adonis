package com.example.adonis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.HashMap;

@SpringBootApplication
public class AdonisApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AdonisApplication.class);

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("server.port", "5050");
        properties.put("spring.datasource.url", "jdbc:mysql://192.168.0.11/adonis");
        properties.put("spring.datasource.username", "root");
        properties.put("spring.datasource.password", "4918Demk!");
        properties.put("spring.jpa.generate-ddl", "true");
        properties.put("spring.jpa.hibernate.ddl-auto", "create-drop");
        properties.put("spring.sql.init.mode", "always");
        properties.put("spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver");

        app.setDefaultProperties(properties);

        app.run(args);
    }
}


