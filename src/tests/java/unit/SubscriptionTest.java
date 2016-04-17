package unit;

import main.java.Feed;
import main.java.Subscription;
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

public class SubscriptionTest {
    @Mock Feed feed;
    @Mock User user;
    private Subscription subscription;

    @Before
    public void initialise(){
        this.subscription = new Subscription(feed);
        subscription.add(user);
    }

    @Test
    public void addAUserSubscription(){
        assertEquals(subscription.getFollowing().contains(user),true);
    }

    @Test
    public void viewFeedShowsPostsFromEachSubscription(){
        List<User> users = Arrays.asList(user);
        subscription.viewPosts();
        verify(feed).view(users);
    }
}