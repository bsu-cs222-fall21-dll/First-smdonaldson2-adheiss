import cs222.bsu.edu.wikipedia.UserInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class SampleTest {

    @Test
    public void testUserInput()
    {
        UserInput userInput = new UserInput();
        String input = "Hello";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals("Hello",userInput.getInput());
    }
}
