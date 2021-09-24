package cs222.bsu.edu.wikipedia;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Revision {

    //convert into timestamp object later
    public String timestamp;
    public String user;
    public String comment;
    public String anon;


    // a




    List<Redirect> createRedirectsList(JsonArray redirectsArray) {
        List<Redirect> redirectsList = new ArrayList<>();
        String from = null;
        String to = null;

        for(JsonElement red : redirectsArray) {
            JsonObject redirectObject = red.getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry : redirectObject.entrySet()) {
                String entryKey = entry.getKey();
                JsonElement entryElement = entry.getValue();
                if(entryKey.equals("from")) {
                    from = entryElement.getAsString();
                }
                else if(entryKey.equals("to")) {
                    to = entryElement.getAsString();
                }
            }

            Redirect redirect = new Redirect(from, to);
            redirectsList.add(redirect);
        }
        return redirectsList;
    }


}
