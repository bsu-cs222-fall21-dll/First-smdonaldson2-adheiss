package cs222.bsu.edu.wikipedia;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GetJSONData {

    public String getSiteData(URL url){
        String json = null;
        try{
            //connects to url
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Revision Tracker/0.1 (smdonaldson2@bsu.edu)");
            connection.connect();
            //gets json data from url and converts to string

            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream);

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
    //converts json data to string
    private static String streamToString(InputStream inputStream){
        return new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\Z").next();
    }
}



