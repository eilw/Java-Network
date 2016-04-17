package main.java;

import java.util.List;

public class Feed {

    public void view(List<User> users){
        for (User user:users) user.viewTimeline(user);
    }
}
