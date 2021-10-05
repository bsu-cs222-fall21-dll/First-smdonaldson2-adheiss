import cs222.bsu.edu.wikipedia.UserInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class TestUserInput {

    @Test
    public void testGetInput() {
        String input = "Drew Heiss";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertEquals("Drew_Heiss", UserInput.getInput());
    }
    @Test
    public void testGetSearchInput(){
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertEquals("5", UserInput.getSearchInput());
    }
    @Test
    public void testGetSearchInputInvalid(){
        String input = "6";
        //six gives out of bounds
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //five is back in bounds
        input = "5";
        InputStream n = new ByteArrayInputStream(input.getBytes());
        System.setIn(n);
        String returned = UserInput.getSearchInput();
        Assertions.assertEquals(returned, "5");
    }
}
