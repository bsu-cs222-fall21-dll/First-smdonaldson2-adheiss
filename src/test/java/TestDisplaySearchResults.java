import cs222.bsu.edu.wikipedia.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestDisplaySearchResults {
    @Test
    public void TestSearchData() {
        DisplaySearchResults searchResults = new DisplaySearchResults();
        String[] resultArr = searchResults.searchData("Dave");

        Assertions.assertEquals(resultArr[0], "Dave");
    }

}
