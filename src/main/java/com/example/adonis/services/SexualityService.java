package com.example.adonis.services;

import com.example.adonis.models.Gender;
import com.example.adonis.models.Sexuality;
import com.example.adonis.repositories.SexualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

public class SexualityService {

    @Autowired
    private SexualityRepository sexualityRepository;

    public Long save(Sexuality sexuality) {
        var doesItExists = sexualityRepository.exists(Example.of(sexuality));
        Long sexualityId;

        if (doesItExists) {
            sexualityId = sexualityRepository.findOne(Example.of(sexuality)).get().getSexualityId();
        } else {
            sexualityId = sexualityRepository.save(sexuality).getSexualityId();
        }

        return sexualityId;
    }
}
