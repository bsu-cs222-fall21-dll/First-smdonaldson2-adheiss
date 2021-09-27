import cs222.bsu.edu.wikipedia.GetJSONData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestGetJSONData {
    @Test
    public void TestGettingJSONData() throws MalformedURLException {
        GetJSONData getJSONData = new GetJSONData();

        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank_Zappa&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30");
        Assertions.assertEquals("{\"continue\":{\"rvcontinue\":\"20210919005429|1045132628\",\"continue\":\"||\"},\"query\":{\"normalized\":[{\"from\":\"Frank_Zappa\",\"to\":\"Frank Zappa\"}],\"pages\":{\"10672\":{\"pageid\":10672,\"ns\":0,\"title\":\"Frank Zappa\",\"revisions\":[{\"user\":\"75.172.213.218\",\"anon\":\"\",\"timestamp\":\"2021-09-19T01:09:23Z\",\"comment\":\"fix numbers\"}]}}}}", getJSONData.getSiteData(url));


    }
}
