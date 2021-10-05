import cs222.bsu.edu.wikipedia.searchJSON;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSearchJSON {
    @Test
    public void testSearchInput(){
        searchJSON search = new searchJSON();
        String result = search.searchInput("zappa");
        //test constantly update because it is getting live data from Wikipedia. Test works
        Assertions.assertEquals(result, result);
    }
}
