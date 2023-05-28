package com.example.adonis.services;

import com.example.adonis.models.Gender;
import com.example.adonis.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public Long save(Gender gender) {
        var doesItExists = genderRepository.exists(Example.of(gender));
        Long genderId;

        if (doesItExists) {
            genderId = genderRepository.findOne(Example.of(gender)).get().getGenderId();
        } else {
            genderId = genderRepository.save(gender).getGenderId();
        }

        return genderId;
    }


}
