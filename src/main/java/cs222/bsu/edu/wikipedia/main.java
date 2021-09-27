package cs222.bsu.edu.wikipedia;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class main {

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        DisplaySearchResults displaySearchResults = new DisplaySearchResults();
        String searchResult = displaySearchResults.searchData();

        System.out.println(ConsoleColors.PURPLE + "Redirected you to: " + searchResult + ConsoleColors.RESET);
        URL url = new URL("https://www.wikipedia.org/w/api.php");
        GetJSONData getJSONData = new GetJSONData();
        URL newUrl = GetJSONData.concatenate(url, searchResult);
        String json = getJSONData.getSiteData(newUrl);

        DisplayRevisionData displayRevisionData = new DisplayRevisionData();
        displayRevisionData.revisionData(json);
    }
}
