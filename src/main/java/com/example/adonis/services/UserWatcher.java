package com.example.adonis.services;

import com.example.adonis.models.Preference;
import com.google.cloud.firestore.*;
import com.google.firebase.database.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserWatcher {
    private final String USER_COLLECTION = "users";

    @Autowired
    ConnectionService connectionService;

    @Autowired
    PreferenceService preferenceService;

    @org.springframework.context.event.EventListener(ApplicationReadyEvent.class)
    public void startWatching() {
        System.out.println("START WATCHING ON USER COLLECTION");
        Firestore db = this.connectionService.getDb();
        CollectionReference reference = db.collection(USER_COLLECTION);

        reference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(
                    @Nullable QuerySnapshot snapshots, @Nullable FirestoreException e) {
                if (e != null) {
                    System.err.println("Listen failed: " + e);
                    return;
                }
                for (DocumentChange dc : snapshots.getDocumentChanges()) {
                    if (dc.getType() == DocumentChange.Type.ADDED) {
                        ArrayList<Preference> preferences = preferenceService.getUserPreference(dc.getDocument());
                        preferenceService.saveBulk(preferences);
                    }
                }
            }
        });
    }
}


/**
 *
 * Skriv method hvor jeg ser hvilke data jeg egentlig får.
 * Bagefter gem dem til databasen.
 * Husk at tilføje UID til preferencen, så man kan returnere dem tilbage.
 * Derfra er det GG.
 *
 */