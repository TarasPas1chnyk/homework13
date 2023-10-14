package org.example.task1;

import org.example.Constants;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PutUserId {
    public static void sendPutUser(URI uri, User user) {
        String s = Constants.GSON.toJson(user);
        System.out.println(s);
        HttpRequest build = HttpRequest.newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(s))
                .build();
        try {
            HttpResponse<String> send = Constants.HTTP_CLIENT.send(build, HttpResponse.BodyHandlers.ofString());
            System.out.println(send.request());
            System.out.println(send.statusCode());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}