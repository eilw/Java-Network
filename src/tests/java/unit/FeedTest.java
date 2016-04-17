package unit;

import main.java.Feed;
import main.java.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)




public class FeedTest {
    @Mock User user;
    private Feed feed;

    @Before
    public void initialise(){
        this.feed = new Feed();
    }

    @Test
    public void viewFeedShowsPostsFromEachSubscription(){
        List<User> users = Arrays.asList(user);
        feed.view(users);
        verify(user).viewTimeline(user);
    }
}