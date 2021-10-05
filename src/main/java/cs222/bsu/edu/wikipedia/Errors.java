package cs222.bsu.edu.wikipedia;


import java.io.IOException;
import java.net.URL;

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
    public Boolean checkNetwork(URL url){
        URLConnection urlConnection = new URLConnection();
        try {
            urlConnection.connect(url);
            return Boolean.FALSE;
        } catch (IOException ioException){
            return Boolean.TRUE;
        }
    }

}
