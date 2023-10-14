package org.example.task1;

import org.example.Constants;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetInformationById {
    public static void getById(int id) {
        HttpRequest build = HttpRequest.newBuilder()
                .uri(URI.create(Constants.URI + "/" + id))
                .GET()
                .build();
        try {
            HttpResponse<String> send = Constants.HTTP_CLIENT.send(build, HttpResponse.BodyHandlers.ofString());
            System.out.println("send.body() = " + send.body());
        } catch (IOException e) {

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
