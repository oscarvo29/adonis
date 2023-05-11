package com.example.adonis.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sexuality {
    private String id;
    private String sexuality;

    public Sexuality(String id, String sexuality) {
        this.id = id;
        this.sexuality = sexuality;
    }
}
