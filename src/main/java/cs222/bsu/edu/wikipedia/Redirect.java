package cs222.bsu.edu.wikipedia;

public class Redirect
{
    String from;
    String to;

    Redirect(String from, String to){
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Redirect{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }


}
