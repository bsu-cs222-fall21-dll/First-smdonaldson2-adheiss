package cs222.bsu.edu.wikipedia;

import java.io.IOException;
import java.net.*;

public class searchJSON {
    public String searchInput(String s){
        String title = null;
        try {
            URL url = new URL("https://www.wikipedia.org/w/api.php");
            URL newUrl = concatenate(url,s);
            HttpURLConnection connection = (HttpURLConnection) newUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            System.out.println(newUrl);
            GetJSONData getJSONData = new GetJSONData();
            String json = getJSONData.getSiteData(newUrl);
            searchFinder searchFinder = new searchFinder();
            search search = searchFinder.getSearchFromJson(json).get(0);
            title = search.title;


        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        //return the title with underscore between letter
         return title.replaceAll("\\s+","_");

    }
    public static URL concatenate(URL baseUrl, String extraPath) throws MalformedURLException, URISyntaxException {
        URI uri = baseUrl.toURI();
        String newPath = uri.getPath() + "?action=query&format=json&list=search&srsearch=" +extraPath+ "&srlimit=1";
        URI newuri = uri.resolve(newPath);
        return newuri.toURL();
    }
}
