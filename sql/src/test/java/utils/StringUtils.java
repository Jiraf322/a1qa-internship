package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import static jsondata.ConfigDataProvider.getLogFileName;
import static jsondata.ConfigDataProvider.getLogFormat;
import static jsondata.ConfigDataProvider.getLogPath;

public class StringUtils {

    public static String getCurrentDate() {
        return new SimpleDateFormat("ddMMyy_HHmmssSSS").format(Calendar.getInstance().getTime());
    }

    public static String getLogName() {
        return getLogPath()+getLogFileName()+getCurrentDate()+getLogFormat();
    }
}
