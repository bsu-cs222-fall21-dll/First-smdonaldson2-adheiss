package cs222.bsu.edu.wikipedia;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionFinder {
    public String getRevisionFromResponse(InputStream inputStream) throws IOException {
        ArrayList<String> username = JsonPath.read(inputStream, "$..revisions[*]..user");
        return username.get(0);
    }
}
