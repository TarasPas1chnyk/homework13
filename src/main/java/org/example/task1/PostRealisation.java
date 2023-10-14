package org.example.task1;

import org.example.Constants;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class PostRealisation {


    public static void sendPost(User user) throws IOException, InterruptedException {

        String s = Constants.GSON.toJson(user);

        try (FileWriter mfw = new FileWriter("my.json")) {
            mfw.write(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.URI))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("my.json")))
                .build();
        HttpResponse<String> response = Constants.HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        User user = new User();
        user.setId(12);
        sendPost(user);
    }
}