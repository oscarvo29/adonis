package com.example.adonis.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Preference {
    private String referenceId;
    private String preference;
    private String referenceDocument;

    public Preference(String referenceId, String preference, String referenceDocument) {
        this.referenceId = referenceId;
        this.preference = preference;
        this.referenceDocument = referenceDocument;
    }
}
