import cs222.bsu.edu.wikipedia.DisplayRevisionData;
import cs222.bsu.edu.wikipedia.TimeConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TestTimeConverter {

    @Test
    public void testConvertLocalTime() {
        TimeConverter timeConverter = new TimeConverter();

        final String input = "2019-08-02T19:38:23Z";
        final String output = timeConverter.convertTime(input);
        Assertions.assertEquals("2019-08-02 15:38:23", output);
    }
}

