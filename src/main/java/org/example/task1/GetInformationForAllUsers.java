package org.example.task1;

import com.google.gson.reflect.TypeToken;
import org.example.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static org.example.Constants.GSON;

public class GetInformationForAllUsers {
    public static void get(URI uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        try {
            HttpResponse<String> send = Constants.HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            ArrayList<User> list = GSON.fromJson(send.body(), new TypeToken<ArrayList<User>>() {
            }.getType());
            try (FileWriter mfr = new FileWriter("allUsers.json")) {
                String allUsers = GSON.newBuilder().setPrettyPrinting().create().toJson(list);
                mfr.write(allUsers);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}