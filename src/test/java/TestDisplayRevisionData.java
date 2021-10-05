import cs222.bsu.edu.wikipedia.DisplayRevisionData;
import cs222.bsu.edu.wikipedia.Finder;
import cs222.bsu.edu.wikipedia.GetJSONRevision;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TestDisplayRevisionData {

    @Test
    public void testConvertLocalTime() {
        DisplayRevisionData displayRevisionData = new DisplayRevisionData();

        final String input = "2019-08-02T19:38:23Z";
        final String output = displayRevisionData.convertTime(input);
        Assertions.assertEquals("2019-08-02 15:38:23", output);
    }
}

