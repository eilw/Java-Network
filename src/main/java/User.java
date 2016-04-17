package main.java;

import java.util.List;

public class User {
    
    private Subscription subscription;
    private Timeline timeline;

    public User(Subscription subscription, Timeline timeline){
        this.subscription = subscription;
        this.timeline = timeline;
    }

    public void post(String message){
        timeline.addPost(message);
    }

    public void follow(User user){
        subscription.add(user);
    }

    public void viewFeed() {
        subscription.viewPosts();
    }

    public void viewTimeline(User user) {
        timeline.view(user);
    }

    public List<String> getTimeline() {
        return timeline.getPosts();
    }
}
