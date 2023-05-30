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
    private static final String CERBERUS_URL = "http://192.168.0.11:3000";

    private CerberusService() {}

    public static CerberusService getInstance() {
        if (cerberus == null)
            cerberus = new CerberusService();

        return cerberus;
    }

    /**
     *  Sends a get request, to the node server, which returns the firebase credentials.
     * @return JSONObject - with Firebase Credentials.
     */
    public JSONObject getFirebaseCredentials() {
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
