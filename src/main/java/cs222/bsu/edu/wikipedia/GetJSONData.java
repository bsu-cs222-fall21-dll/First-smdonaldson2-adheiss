package cs222.bsu.edu.wikipedia;



import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GetJSONData {
    public static String connectUrl(){
        String json = null;
        try {
            URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank_Zappa&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            //Error Class Code, temporarily here
            if(responseCode!= 200){
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }
            //function if response does not = 200 (200 = success)
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
//    public static void main(String[] args){
//        System.out.println(connectUrl());
//    }
}



