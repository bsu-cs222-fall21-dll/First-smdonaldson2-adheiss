package cs222.bsu.edu.wikipedia;

public class Errors {
    public void exitCodeOne(){
        System.err.println("You must enter something!");
        System.exit(1);
    }
    public void exitCodeTwo(){
        System.err.println("Your search did not exist");
        System.exit(2);
    }
    public void exitCodeThree(){
        System.err.println("Network Error");
        System.exit(3);
    }
}
