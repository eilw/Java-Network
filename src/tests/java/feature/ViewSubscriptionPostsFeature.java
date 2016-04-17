package feature;

import main.java.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class ViewSubscriptionPostsFeature {

    @Mock Presenter presenter;

    private User leo;
    private User nikesh;
    private User spike;

    @Before
    public void initialise(){
        Feed feed = new Feed();
        Subscription leoSubscriptions = new Subscription(feed);
        Subscription nikeshSubscriptions = new Subscription(feed);
        Subscription spikeSubscriptions = new Subscription(feed);
        Timeline leoTimeline = new Timeline(presenter);
        Timeline nikeshTimeline = new Timeline(presenter);
        Timeline spikeTimeline = new Timeline(presenter);
        leo = new User(leoSubscriptions, leoTimeline);
        nikesh = new User(nikeshSubscriptions, nikeshTimeline);
        spike = new User(spikeSubscriptions, spikeTimeline);
    }

    @Test
    public void viewFeedFeature() {
        leo.post("Leo first post");
        leo.viewTimeline(leo);
        verify(presenter).printLine("Leo first post");
        nikesh.post("Nikesh first post");
        spike.post("Spike first post");
        leo.follow(nikesh);
        leo.follow(spike);
        leo.viewFeed();
        verify(presenter).printLine("Nikesh first post");
        verify(presenter).printLine("Spike first post");
    }
}
