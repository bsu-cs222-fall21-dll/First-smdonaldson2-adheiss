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
        //Class needs a url to function, test will fail when page gets updated
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank_Zappa&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30");
        Assertions.assertEquals("{\"continue\":{\"rvcontinue\":\"20210724151043|1035249818\",\"continue\":\"||\"},\"query\":{\"normalized\":[{\"from\":\"Frank_Zappa\",\"to\":\"Frank Zappa\"}],\"pages\":{\"10672\":{\"pageid\":10672,\"ns\":0,\"title\":\"Frank Zappa\",\"revisions\":[{\"user\":\"75.172.213.218\",\"anon\":\"\",\"timestamp\":\"2021-09-19T01:09:23Z\",\"comment\":\"fix numbers\"}]}}}}", getJSONRevision.getSiteData(url));
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

