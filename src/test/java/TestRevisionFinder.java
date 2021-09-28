
import cs222.bsu.edu.wikipedia.Finder;
import cs222.bsu.edu.wikipedia.GetJSONRevision;
import cs222.bsu.edu.wikipedia.Revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestRevisionFinder {


    @Test
    public void testGetRevisionFromJson() throws MalformedURLException {
        Finder finder = new Finder();
        GetJSONRevision jsonData = new GetJSONRevision();
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank_Zappa&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30");

        Revision revision = finder.getRevisionFromJson(jsonData.getSiteData(url)).get(0);
        System.out.println(revision.user);

        Assertions.assertEquals("DVdm", revision.user);

    }

}
