package cs222.bsu.edu.wikipedia;

import java.util.Scanner;

public class UserInput {

    public static String getInput(){
        Scanner input =  new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE+"Please Enter Your Search:"+ConsoleColors.RESET);
        String userInput = input.nextLine();
        return userInput.replaceAll("\\s+","_");
    }

    public static String getSearchInput(){
        Scanner input =  new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE+"Enter the page title you want to search: "+ConsoleColors.RESET);
        String userInput = input.nextLine();
        return userInput.replaceAll("\\s+","_");
    }


}
