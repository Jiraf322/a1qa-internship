package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;
import static jsondata.ConfigConstants.KEY_FORMAT;
import static jsondata.ConfigConstants.CONFIG_DATA_FILE;

public class JsonGetter {

    public static int getConfigInt(String key) {
        return Integer.parseInt(getConfigString(key));
    }

    public static String getConfigString(String key) {
        return JsonGetter.getData(CONFIG_DATA_FILE, String.format(KEY_FORMAT, key));
    }

    private static String getData(String file, String value) {
        return new JsonSettingsFile(file).getValue(value).toString();
    }
}