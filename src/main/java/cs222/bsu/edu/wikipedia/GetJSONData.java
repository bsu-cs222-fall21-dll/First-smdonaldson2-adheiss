package cs222.bsu.edu.wikipedia;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetJSONData {
    public static void connectUrl(){
        try {
            URL url = new URL("https://www.mediawiki.org/wiki/Special:MyLanguage/API:Revisions");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responsecode = connection.getResponseCode();
            System.out.println(responsecode);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args){
        connectUrl();
    }
}



