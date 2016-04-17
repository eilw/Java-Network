package unit;

import main.java.Presenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class PresenterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Presenter presenter;

    @Before
    public void initialise(){
        this.presenter = new Presenter();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void printsOutMessage() {
        presenter.printLine("This is an example");
        assertEquals("This is an example\n", outContent.toString());
    }

}
