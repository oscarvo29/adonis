package com.example.adonis.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@Getter @Setter
@Entity @Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genderId;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "preference_id")
    private Preference preference;
}
