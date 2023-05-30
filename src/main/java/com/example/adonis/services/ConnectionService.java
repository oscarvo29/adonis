package com.example.adonis.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;

@Service
public class ConnectionService {
    private InputStream serviceAccount = null;
    private FirebaseOptions options = null;
    private Firestore db = null;
    private CerberusService cerberus = null;




    public ConnectionService() {
        try {

            cerberus = CerberusService.getInstance();
            JSONObject credentials = cerberus.getFirebaseCredentials();
            String credentialsString = credentials.toString();
            serviceAccount = new ByteArrayInputStream(credentialsString.getBytes());
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
