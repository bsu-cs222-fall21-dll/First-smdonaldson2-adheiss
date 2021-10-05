import cs222.bsu.edu.wikipedia.GetJSONRevision;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class TestGetJSONData {
    @Test
    public void TestGettingJSONRevision() throws MalformedURLException {
        GetJSONRevision getJSONRevision = new GetJSONRevision();
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank_Zappa&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30");
        //class returns live data, test works
        Assertions.assertEquals(getJSONRevision.getSiteData(url), getJSONRevision.getSiteData(url));
    }
    @Test
    public void TestConcatenate() throws MalformedURLException, URISyntaxException {
        GetJSONRevision getJSONRevision = new GetJSONRevision();
        URL url = new URL("https://www.wikipedia.org/w/api.php");
        GetJSONRevision getJSONData = new GetJSONRevision();
        URL newUrl = GetJSONRevision.concatenate(url, "Thanos");
        URL testURL = new URL("https://www.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Thanos&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30");
        Assertions.assertEquals(newUrl,testURL);
    }


}

