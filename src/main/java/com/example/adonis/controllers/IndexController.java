package com.example.adonis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/hello-world")
    private String helloWorld() {
        return "Hello world";
    }
}
