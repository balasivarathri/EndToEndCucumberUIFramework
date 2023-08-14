package tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CoreDateTime {
    public CoreDateTime(){
    }
    public static String getTimeStamp(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date =  new Date();
        return dateFormat.format(date);
    }
}
