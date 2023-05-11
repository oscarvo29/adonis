package com.example.adonis.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ConnectionService {
    private FileInputStream serviceAccount = null;
    private FirebaseOptions options = null;
    private  Firestore db = null;

    public ConnectionService() {
        try {
            serviceAccount = new FileInputStream("src/main/resources/fireo-db-connector.json");
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    public Firestore getDb() {
        return db;
    }

    public void closeDbConnection() {
        try {
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
