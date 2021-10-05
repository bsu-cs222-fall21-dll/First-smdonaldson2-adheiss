package cs222.bsu.edu.wikipedia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DisplayRevisionData {

    private void printToConsole(String user, String comment, String timestamp ){
        System.out.println("User: " + user + "\nComment: "+ comment + "\nTimestamp: " + timestamp );
    }

    public void revisionData(String json){
        TimeConverter timeConverter = new TimeConverter();
        Finder finder = new Finder();

        for(int i = 0;i<30;i++){
            Revision revision = finder.getRevisionFromJson(json).get(i);
            String user = revision.user;
            String comment = revision.comment;
            String timestamp = timeConverter.convertTime(revision.timestamp);

            System.out.println(ConsoleColors.RED+"Revision Number: "+ (i+1) + ConsoleColors.RESET);

            printToConsole(user,comment,timestamp);
        }

    }


}
