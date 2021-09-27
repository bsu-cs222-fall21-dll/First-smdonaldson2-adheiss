package cs222.bsu.edu.wikipedia;


import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GetJSONData {

    public String getSiteData(URL url){
        String json = null;
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
    private static String streamToString(InputStream inputStream){
        return new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\Z").next();
    }
    public static URL concatenate(URL baseUrl, String extraPath) throws MalformedURLException, URISyntaxException {
        URI uri = baseUrl.toURI();
        String newPath = uri.getPath() + "?action=query&format=json&prop=revisions&titles=" + extraPath + "&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=30";
        URI newuri = uri.resolve(newPath);
        return newuri.toURL();
    }


}



