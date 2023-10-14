package org.example.task1;

import org.example.Constants;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteUser {
    public static void delete(User user, URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .DELETE()
                .build();
        try {
            HttpResponse<String> send = Constants.HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("send.statusCode() = " + send.statusCode());
            System.out.println("send.body() = " + send.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}