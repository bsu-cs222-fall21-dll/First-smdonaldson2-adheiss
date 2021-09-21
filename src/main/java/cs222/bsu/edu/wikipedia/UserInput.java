package cs222.bsu.edu.wikipedia;

import java.util.Scanner;

public class UserInput {
    public String getInput(){
        Scanner input =  new Scanner(System.in);
        System.out.println("Please Enter Your Search:");
        return input.nextLine();
    }
}
