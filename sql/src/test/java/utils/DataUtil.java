package utils;

import static jsondata.ConfigDataProvider.*;

public class DataUtil {

    public static String getLogName() {
        return getLogPath()+getLogFileName()+ StringUtils.getCurrentDate()+getLogFormat();
    }
}
