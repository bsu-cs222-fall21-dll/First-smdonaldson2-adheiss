import cs222.bsu.edu.wikipedia.DisplayRevisionData;
import cs222.bsu.edu.wikipedia.GetJSONData;
import cs222.bsu.edu.wikipedia.RevisionFinder;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDisplayRevisionData {
    @Test

    public void testPrintToConsole() throws MalformedURLException {

        RevisionFinder finder = new RevisionFinder();
        GetJSONData jsonData = new GetJSONData();
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank_Zappa&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30");
        String json = jsonData.getSiteData(url);

        DisplayRevisionData data = new DisplayRevisionData();
        data.revisionData(json);

    }
}
