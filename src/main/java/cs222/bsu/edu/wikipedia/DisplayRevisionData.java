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

        Finder finder = new Finder();

        for(int i = 0;i<30;i++){
            Revision revision = finder.getRevisionFromJson(json).get(i);
            String user = revision.user;
            String comment = revision.comment;
            String timestamp = convertTime(revision.timestamp);

            System.out.println(ConsoleColors.RED+"Revision Number: "+ (i+1) + ConsoleColors.RESET);

            printToConsole(user,comment,timestamp);
        }

    }

    public String convertTime(String timestamp){
        SimpleDateFormat timeStampForm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        timeStampForm.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = new Date();
        try
        {
            date = timeStampForm.parse(timestamp);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        timeStampForm.setTimeZone(TimeZone.getDefault());

        Date localDate = new Date();
        String localTime = timeStampForm.format(date.getTime());
        try
        {
            localDate = timeStampForm.parse(localTime);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        SimpleDateFormat localDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(localDate);
    }

}
