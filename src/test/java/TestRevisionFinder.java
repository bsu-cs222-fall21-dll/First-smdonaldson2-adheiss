import cs222.bsu.edu.wikipedia.GetJSONData;
import cs222.bsu.edu.wikipedia.Revision;
import cs222.bsu.edu.wikipedia.RevisionFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class TestRevisionFinder {
    @Test
    public void testGetRevisionFromResponse() throws IOException {
        RevisionFinder finder = new RevisionFinder();
        InputStream jsonResponse = Thread.currentThread().getContextClassLoader().getResourceAsStream("testresponse.json");
        Assertions.assertEquals("75.172.213.218", finder.getRevisionFromResponse(jsonResponse));
    }

    @Test
    public void testGetRevisionFromJson() throws MalformedURLException {
        RevisionFinder finder = new RevisionFinder();
        GetJSONData jsonData = new GetJSONData();
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank_Zappa&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30");

        Revision revision = finder.getRevisionFromJson(jsonData.getSiteData(url)).get(0);
        System.out.println(revision.user);
//        Assertions.assertEquals("75.172.213.218", revision.user);
//        Assertions.assertEquals("/* Business breakups and touring */ clarifications and fix numbers", revision.comment);
    }
}
