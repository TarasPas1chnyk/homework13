package org.example.task3;

import com.google.gson.reflect.TypeToken;
import org.example.Constants;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class TasksNotCompleted {
    public static ArrayList<UserTasks> getTasks(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id + "/todos";
        ArrayList<UserTasks> list;
        try {
            String text = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .text();
            list = Constants.GSON.fromJson(text, new TypeToken<ArrayList<UserTasks>>() {
            }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void printTasks(int id) {
        for (UserTasks task : getTasks(id)) {
            if (!task.isCompleted()){
                System.out.println(task.getTitle() + " \n" + "Not completed:" + task.isCompleted());
            }
        }
    }
}