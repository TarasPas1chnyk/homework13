package org.example.task1;

import org.example.Constants;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetIngormationByUsername {
    public static void getByUserName(String username) {
        String url = Constants.URI + "?username=" + username;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> send = Constants.HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(send.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}