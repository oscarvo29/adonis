package com.example.adonis.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table @Data
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preferenceId;
    private String firUid;
    private String gender;
    private String preference;

    public Preference(String firUid, String gender, String preference) {
        this.firUid = firUid;
        this.gender = gender;
        this.preference = preference;
    }
}
