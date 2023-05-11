package com.example.adonis.services;

import com.example.adonis.models.User;
import com.example.adonis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserInfo(String uid) {
        return userRepository.getActiveUserInfo(uid);
    }

    public ArrayList<String> getLikeAbleUIDs(User user) {
        return userRepository.getLikeAbleUIDs(user);
    }
}
