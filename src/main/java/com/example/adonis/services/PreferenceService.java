package com.example.adonis.services;

import com.example.adonis.models.Preference;
import com.example.adonis.repositories.PreferenceRepository;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    // Repositories call.
    public void save(Preference preference) {
        preferenceRepository.save(preference);
    }

    public void saveBulk(ArrayList<Preference> preferences) {
        preferenceRepository.saveAll(preferences);
    }

    // Service logic.
    public ArrayList<Preference> getUserPreference(QueryDocumentSnapshot snapshot) {
        ArrayList<Preference> preferencesList = new ArrayList<>();

        Map<String, Object> data = snapshot.getData();
        Map<String, Object> genderMap = (Map<String, Object>) data.get("gender");
        ArrayList<String> preferences = (ArrayList<String>) data.get("preference");

        for (String preference : preferences) {
            Preference preference1 = new Preference(String.valueOf(data.get("uid")), String.valueOf(genderMap.get("gender")), preference);
            preferencesList.add(preference1);
        }

        return preferencesList;
    }
}
