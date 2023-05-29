package com.example.adonis.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ConnectionService {
    private InputStream serviceAccount = null;
    private FirebaseOptions options = null;
    private Firestore db = null;

    @Autowired
    ResourceLoader resourceLoader;

    public ConnectionService() {
        try {

            Resource resource = resourceLoader.getResource("classpath:fireo-db-connector.json");

            serviceAccount = resource.getInputStream();
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
