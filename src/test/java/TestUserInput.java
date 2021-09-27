import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
