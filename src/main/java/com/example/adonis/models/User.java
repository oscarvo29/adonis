package com.example.adonis.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class User {
    private String uid;
    private String fullname;
    private String email;
    private int age;
    private Gender gender;
    private Sexuality sexuality;
    private String phonenumber;
    private String bio;
    private String cityName;
    private String latitude;
    private String longitude;
    private ArrayList<String> images;
    private ArrayList<Preference> preferences;

    public User(String uid, String fullname, String email, int age, Gender gender, Sexuality sexuality, String phonenumber, String bio, String cityName, String latitude, String longitude, ArrayList<String> images) {
        this.uid = uid;
        this.fullname = fullname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.sexuality = sexuality;
        this.phonenumber = phonenumber;
        this.bio = bio;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.images = images;
    }

    public User() {
    }

    public User(String uid, Gender gender, ArrayList<Preference> preferences, int age) {
        this.uid = uid;
        this.gender = gender;
        this.preferences = preferences;
        this.age = age;
    }

    public ArrayList<String> getPreferencesStrings() {
        ArrayList<String> preferenceList = new ArrayList<>();
        for(Preference preference : this.preferences) {
            preferenceList.add(preference.getPreference());
        }

        return preferenceList;
    }
}
