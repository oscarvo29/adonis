package com.example.adonis.controllers;

import com.example.adonis.models.User;
import com.example.adonis.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    private ArrayList<String> getUserInfo() throws JsonProcessingException {
        User user = userService.getUserInfo("OPaOwSwzuBeQXb6XqIctBvjYkkm2");

        System.out.println(user.getFullname());
        return userService.getLikeAbleUIDs(user);
    }

    @GetMapping("/hello-world")
    private String helloWorld() {
        return "Hello world";
    }
}
