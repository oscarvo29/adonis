package com.example.adonis.repositories;

import com.example.adonis.models.Gender;
import com.example.adonis.models.Preference;
import com.example.adonis.models.Sexuality;
import com.example.adonis.models.User;
import com.example.adonis.services.ConnectionService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.database.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Repository
public class UserRepository {

    private Firestore db = null;

    @Autowired
    private ConnectionService connectionService;

    @Value("${USER_COLLECTION}")
    private String userCollection;

    public User getActiveUserInfo(String uid) {
        User user = null;
        this.db = connectionService.getDb();
        try {
            CollectionReference userReference = db.collection(userCollection);
            Query query =  userReference.whereEqualTo("uid", uid);
            QuerySnapshot querySnapshotApiFuture = query.get().get();

            for (DocumentSnapshot document : querySnapshotApiFuture.getDocuments()) {
                //Map<String, String> genderMap = (Map<String, String>) document.get("gender");
                String genderSTring = document.get("gender", String.class);
                ArrayList<Map<String, String>> preferenceList = (ArrayList<Map<String, String>>) document.get("preference");
                //Gender gender = new Gender(genderMap.get("id"), genderMap.get("gender"));
                Gender gender = new Gender("test", genderSTring);
                ArrayList<Preference> preferences = new ArrayList<>();

                for (Map<String, String> preference : preferenceList) {
                    Preference pref = new Preference(preference.get("id"), preference.get("preference"), preference.get("referenceDocument"));
                    preferences.add(pref);
                }
                int age = document.get("age", Integer.class);
                user = new User(uid, gender, preferences, age);
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public ArrayList<String> getLikeAbleUIDs(User user) {
        ArrayList<String> uids = new ArrayList<>();
        Firestore db = connectionService.getDb();

        try {
            CollectionReference usersReference = db.collection(userCollection);
            Query query = usersReference.whereEqualTo("gender", "female").whereArrayContains("preference", "male");
            QuerySnapshot querySnapshot = query.get().get();

            for(DocumentSnapshot document : querySnapshot.getDocuments()) {
                uids.add(document.get("uid", String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return uids;
    }

    //

}
