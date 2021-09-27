package cs222.bsu.edu.wikipedia;

import java.net.*;

import static cs222.bsu.edu.wikipedia.UserInput.getInput;

public class Main {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        String query  = getInput();
        searchJSON searchJSON = new searchJSON();
        String searchResult = searchJSON.searchInput(query);

        System.out.println("Your search result: " + searchResult);

        URL url = new URL("https://en.wikipedia.org/w/api.php");
        URI uri = url.toURI();
        String newPath = uri.getPath() + "?action=query&format=json&prop=revisions&titles=" + searchResult + "&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30";

        URI newURI = uri.resolve(newPath);
        URL newUrl = newURI.toURL();

        GetJSONData getJSONData = new GetJSONData();
        String json = getJSONData.getSiteData(newUrl);

        DisplayRevisionData displayRevisionData = new DisplayRevisionData();
        displayRevisionData.revisionData(json);

    }
}
