package app.com.moviedb.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateUtils {

    public static String getStringDate(String date)
    {
        String dateArray[] = date.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date mDate = sdf.parse(date);
            long timeInMilliseconds = mDate.getTime();
            String resultDate = formatDate(timeInMilliseconds)+", "+dateArray[0];
            return resultDate;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return "";
    }


    public static String formatDate(long timeInMillis) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd", Locale.getDefault());
        return dateFormat.format(timeInMillis);
    }


}
