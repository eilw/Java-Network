package unit;

import main.java.Presenter;
import main.java.Subscription;
import main.java.Timeline;
import main.java.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class UserTest {
    @Mock Subscription subscription;
    @Mock Timeline timeline;

    private User firstTestUser;
    private User secondTestUser;

    @Before
    public void initialise(){
        firstTestUser = new User(subscription,timeline);
        secondTestUser = new User(subscription,timeline);
        firstTestUser.post("First message");
    }

    @Test
    public void addsMsgToTimeline() {
        verify(timeline).addPost("First message");
    }

    @Test
    public void retrievesPostsFromTimeline(){
        firstTestUser.getTimeline();
        verify(timeline).getPosts();
    }

    @Test
    public void viewTimeLineFromAnotherUser() {
        secondTestUser.viewTimeline(firstTestUser);
        verify(timeline).view(firstTestUser);
    }

    @Test
    public void storesUserToBeFollowed(){
        secondTestUser.follow(firstTestUser);
        verify(subscription).add(firstTestUser);
    }

    @Test
    public void seePostsFromAnotherUser(){
        secondTestUser.follow(firstTestUser);
        secondTestUser.viewFeed();
        verify(subscription).viewPosts();
    }
}
