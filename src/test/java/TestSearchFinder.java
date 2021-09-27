import cs222.bsu.edu.wikipedia.GetJSONData;
import cs222.bsu.edu.wikipedia.search;
import cs222.bsu.edu.wikipedia.searchFinder;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSearchFinder {
    @Test
    public void testGetSearchFromJson() throws MalformedURLException {
        searchFinder finder = new searchFinder();
        GetJSONData jsonData = new GetJSONData();
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=zappa&srlimit=1");

        search search = finder.getSearchFromJson(jsonData.getSiteData(url)).get(0);
        System.out.println(search.title);

    }
}
