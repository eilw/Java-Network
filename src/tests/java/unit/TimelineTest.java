package unit;

import main.java.Presenter;
import main.java.Timeline;
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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class TimelineTest {
    @Mock Presenter presenter;
    @Mock User user;
    private Timeline timeline;

    @Before
    public void initialise(){
        this.timeline = new Timeline(presenter);
    }

    @Test
    public void aPostIsStored(){
        timeline.addPost("First message");
        assertEquals(timeline.getPosts().contains("First message"),true);
    }

    @Test
    public void retrievesUserTimeline(){
        timeline.view(user);
        verify(user).getTimeline();
    }

    @Test
    public void printsEachPost(){
        List<String> messages = Arrays.asList("First message");
        when(user.getTimeline()).thenReturn(messages);
        timeline.view(user);
        verify(presenter).printLine("First message");
    }

}