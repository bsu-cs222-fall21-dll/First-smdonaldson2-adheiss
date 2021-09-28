import cs222.bsu.edu.wikipedia.DisplayRevisionData;
import cs222.bsu.edu.wikipedia.GetJSONRevision;
import cs222.bsu.edu.wikipedia.UserInput;
import cs222.bsu.edu.wikipedia.searchJSON;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDisplaySearchResults {
    @Test
    public void TestSearchData() throws MalformedURLException {
        String input = UserInput.getInput();
        searchJSON searchJSON = new searchJSON();
        String json = searchJSON.searchInput(input);


        DisplayRevisionData data = new DisplayRevisionData();
        //class is void, it's a printing function
        data.revisionData(json);

    }
}
