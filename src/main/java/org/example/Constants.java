package org.example;

import com.google.gson.Gson;

import java.net.http.HttpClient;

public class Constants {
    public static final String URI = "http://jsonplaceholder.typicode.com/users";
    public static final Gson GSON = new Gson();
    public static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
}