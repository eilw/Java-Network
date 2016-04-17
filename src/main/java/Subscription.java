package main.java;

import java.util.ArrayList;
import java.util.List;

public class Subscription {

    private List<User> following;
    private Feed feed;

    public Subscription(Feed feed){
        this.following = new ArrayList<User>();
        this.feed = feed;
    }

    public void add(User user) {
        following.add(user);
    }

    public List<User> getFollowing() {
        return following;
    }

    public void viewPosts() {
        feed.view(getFollowing());
    }
}
