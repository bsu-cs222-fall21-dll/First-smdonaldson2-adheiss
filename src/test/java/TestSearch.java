import cs222.bsu.edu.wikipedia.searchJSON;
import org.junit.jupiter.api.Test;

public class TestSearch {
    @Test
    public void testSearchInput(){
        searchJSON search = new searchJSON();
        String r = search.searchInput("zappa");
        System.out.println(r);
    }
}
