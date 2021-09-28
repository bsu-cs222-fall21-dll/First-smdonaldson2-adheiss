package cs222.bsu.edu.wikipedia;

import java.util.Scanner;

public class UserInput {

    public static String getInput(){
        Scanner input =  new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE+"Please Enter Your Search:"+ConsoleColors.RESET);
        String userInput = input.nextLine();
        if(userInput.equals("")){
            Errors errors = new Errors();
            errors.exitCodeOne();
        }
        return userInput.replaceAll("\\s+","_");
    }

    public static String getSearchInput(){
        Scanner input =  new Scanner(System.in);
        int userInput;

        System.out.println(ConsoleColors.BLUE+"Enter the corresponding number to the title you would like to search: "+ConsoleColors.RESET);
        while(true){
            userInput = input.nextInt();
            if(userInput<1 || userInput>5){
                System.out.println("Please enter a number 1-5");
            }
            else if(Integer.toString(userInput).equals("")){
                Errors errors = new Errors();
                errors.exitCodeOne();
            }
            else{
                break;
            }
        }

        return Integer.toString(userInput);



    }


}
