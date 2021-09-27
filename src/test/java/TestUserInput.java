import cs222.bsu.edu.wikipedia.GetJSONData;
import cs222.bsu.edu.wikipedia.Revision;

import cs222.bsu.edu.wikipedia.RevisionFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class TestUserInput {
    private Scanner scanner = new Scanner(System.in);


    @Test
    public void testUserInput() {
        String testInputString;
        System.out.println("Enter in the term you want to get data for: ");
        System.out.println("\n");
        testInputString = scanner.nextLine();
        Assertions.assertEquals("Frank Zappa", testInputString);

    }
}
