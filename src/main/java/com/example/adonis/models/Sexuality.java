package com.example.adonis.models;

import jakarta.persistence.*;
import lombok.*;


@Entity @Table
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sexuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sexualityId;
    private String sexuality;

    @ManyToOne
    @JoinColumn(name = "preference_id")
    private Preference preference;
}
