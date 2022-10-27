package jsondata;

import utils.JsonGetter;
import static jsondata.ConfigConstants.*;

public class ConfigDataProvider {

    public static String getCredentialsPath() {
        return JsonGetter.getConfigString(CREDENTIALS_FILE_PATH);
    }

    public static String getQueryPath() {
        return JsonGetter.getConfigString(QUERY_FILE_PATH);
    }

    public static String getLogPath() {
        return JsonGetter.getConfigString(LOG_FILE_PATH);
    }

    public static String getLogFormat() {
        return JsonGetter.getConfigString(LOG_FORMAT);
    }

    public static String getLogFileName() {
        return JsonGetter.getConfigString(LOG_FILE_NAME);
    }
}
