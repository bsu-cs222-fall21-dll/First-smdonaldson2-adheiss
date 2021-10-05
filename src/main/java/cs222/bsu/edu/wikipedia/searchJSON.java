package cs222.bsu.edu.wikipedia;

import java.io.IOException;
import java.net.*;

public class searchJSON {
    public String searchInput(String s){
        String json = " ";
        try {
            URL url = new URL("https://www.wikipedia.org/w/api.php");
            URL newUrl = concatenate(url,s);

            URLConnection urlConnection = new URLConnection();
            urlConnection.connect(newUrl);

            GetJSONRevision getJSONData = new GetJSONRevision();

            json = getJSONData.getSiteData(newUrl);

        } catch (IOException | URISyntaxException ioException) {
            Errors errors = new Errors();
            errors.exitCodeThree();
        }

        return json;


    }
    public URL concatenate(URL baseUrl, String extraPath) throws MalformedURLException, URISyntaxException {
        URI uri = baseUrl.toURI();
        String newPath = uri.getPath() + "?action=query&format=json&list=search&srsearch=" +extraPath+ "&srlimit=5";

        URI newUri = uri.resolve(newPath);
        return newUri.toURL();
    }
}
