package com.example.adonis.services;

import jdk.jshell.execution.Util;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.Scanner;

/**
 *  A singleton class, that will get firebase credentials from a Node Express REST api.
 */
public class CerberusService {
    private static CerberusService cerberus = null;
    private static JSONObject firebase_credentials = null;
    private static final String CERBERUS_URL = "http://192.168.0.11:3000";

    private CerberusService() {}

    public static CerberusService getInstance() {
        if (cerberus == null)
            cerberus = new CerberusService();

        return cerberus;
    }

    /**
     *  Checks if the firebase credentials all ready have been loaded, if they have
     *  it just returns them, else it will send a request for them.
     * @return JSONObject - Firebase Credential file.
     */
    public JSONObject getFirebaseCredentials() {
        if (firebase_credentials == null)
            firebase_credentials = requestCredentials();

        return firebase_credentials;
    }

    /**
     *  Sends a get request, to the node server, which returns the firebase credentials.
     * @return JSONObject - with Firebase Credentials.
     */
    private JSONObject requestCredentials() {
        try {
            URL url = new URL(CERBERUS_URL);
            Scanner scanner = new Scanner(url.openStream());
            String response = scanner.useDelimiter("\\Z").next();
            JSONObject json = new JSONObject(response);
            scanner.close();

            return json;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
