package main.java;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

    private Presenter presenter;
    private List<String> posts;

    public Timeline(Presenter presenter){
        this.presenter = presenter;
        this.posts = new ArrayList<String>();
    }

    public void addPost(String message) {
        posts.add(message);
    }

    public List<String> getPosts() {
        return posts;
    }

    public void view(User user) {
        for (String msg:user.getTimeline()) presenter.printLine(msg);
    }
}
