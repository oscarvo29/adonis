package com.example.adonis.services;

import com.google.cloud.firestore.*;
import com.google.firebase.database.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

@Service
public class UserWatcher {
    private final String USER_COLLECTION = "useres";

    @Autowired
    ConnectionService connectionService;

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
                        System.out.println("New user: " + dc.getDocument().getData().get("fullname"));
                    }
                }
            }
        });
    }
}
