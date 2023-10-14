package org.example.task2;

import com.google.gson.reflect.TypeToken;
import org.example.Constants;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CommentsAndPosts {
    public static ArrayList<Post> getPosts(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id + "/posts";
        ArrayList<Post> list;
        try {
            String text = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .text();
            list = Constants.GSON.newBuilder().setPrettyPrinting()
                    .create()
                    .fromJson(text, new TypeToken<ArrayList<Post>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static ArrayList<Comments> getComments(int id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + getPosts(id).get(getPosts(id).size() - 1).getId() + "/comments";
        ArrayList<Comments> list;
        try {
            String text = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .text();
            list = Constants.GSON.newBuilder().setPrettyPrinting()
                    .create()
                    .fromJson(text, new TypeToken<ArrayList<Comments>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void getPostsAndComments(int id) {
        System.out.println(getComments(id));
        Post post = getPosts(id).get(getPosts(id).size() - 1);
        String file = "user-" + id + "-post-" + post.getId() + "-comments.json";

        try (FileWriter fileWriter = new FileWriter(new File(file))) {
            String s = Constants.GSON.newBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(getComments(id));
            fileWriter.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}