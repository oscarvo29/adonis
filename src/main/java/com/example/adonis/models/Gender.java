package com.example.adonis.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gender {

    private String id;
    private String gender;

    public Gender(String id, String gender) {
        this.id = id;
        this.gender = gender;
    }
}
