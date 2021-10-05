import cs222.bsu.edu.wikipedia.DisplayRevisionData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TestDisplayRevisionData {

    @Test
    public void testConvertLocalTime() {
        DisplayRevisionData displayRevisionData = new DisplayRevisionData();

        final String input = "2019-08-02T19:38:23Z";
        final String output = displayRevisionData.convertTime(input);
        Assertions.assertEquals("2019-08-02 15:38:23", output);
    }
}

