package cs222.bsu.edu.wikipedia;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection {
    public InputStream connect(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent","Revision Tracker/v0.1.0 (smdonaldson2@bsu.edu)");
        connection.connect();
        return connection.getInputStream();
    }
}
