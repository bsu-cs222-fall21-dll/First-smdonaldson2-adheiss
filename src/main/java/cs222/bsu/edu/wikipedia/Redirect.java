package cs222.bsu.edu.wikipedia;

public class Redirect
{
    String from;
    String to;

    Redirect(String from, String to){
        this.from = from;
        this.to = to;
    }
// words in conjunction with the revision class
// to redirect the user to the top result for their search
    @Override
    public String toString() {
        return "Redirect{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}
