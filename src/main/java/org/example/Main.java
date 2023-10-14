package org.example;

import org.example.task1.User;
import org.example.task3.TasksNotCompleted;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        User user = new User();
        int id = 1;
        user.setId(1);
        String url = Constants.URI + "/" + id;
//        PutUserId.sendPutUser(URI.create(url), user);
//        DeleteUser.delete(user, URI.create(url));
//        PostRealisation.sendPost(user);
//        GetInformationForAllUsers.get(URI.create(Constants.URI));
//        GetInformationById.getById(3);
//          GetIngormationByUsername.getByUserName("Karianne");
//        CommentsAndPosts.getPostsAndComments(1);
        TasksNotCompleted.printTasks(4);
    }
}