package cs222.bsu.edu.wikipedia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeConverter {
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
