import cs222.bsu.edu.wikipedia.RevisionFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestRevisionFinder {
    @Test
    public void testGetRevisionFromResponse() throws IOException {
        RevisionFinder finder = new RevisionFinder();
        InputStream jsonResponse = Thread.currentThread().getContextClassLoader().getResourceAsStream("testresponse.json");
        Assertions.assertEquals("75.172.213.218", finder.getRevisionFromResponse(jsonResponse));
    }
}
