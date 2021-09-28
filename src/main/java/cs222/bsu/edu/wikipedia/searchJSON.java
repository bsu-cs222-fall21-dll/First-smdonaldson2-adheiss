package cs222.bsu.edu.wikipedia;

import java.io.IOException;
import java.net.*;

public class searchJSON {
    public String searchInput(String s){
        String json = " ";
        try {
            URL url = new URL("https://www.wikipedia.org/w/api.php");
            URL newUrl = concatenate(url,s);

            HttpURLConnection connection = (HttpURLConnection) newUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Revision Tracker/v0.1.0 (smdonaldson2@bsu.edu)");
            connection.connect();

            GetJSONRevision getJSONData = new GetJSONRevision();

            json = getJSONData.getSiteData(newUrl);

        } catch (IOException | URISyntaxException ioException) {
            Errors errors = new Errors();
            errors.exitCodeThree();
        }

        return json;


    }
    public static URL concatenate(URL baseUrl, String extraPath) throws MalformedURLException, URISyntaxException {
        URI uri = baseUrl.toURI();
        String newPath = uri.getPath() + "?action=query&format=json&list=search&srsearch=" +extraPath+ "&srlimit=5";

        URI newUri = uri.resolve(newPath);
        return newUri.toURL();
    }
}
