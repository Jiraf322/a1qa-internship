package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;

import static testdata.TestConstants.KEY_FORMAT;
import static testdata.TestConstants.TEST_DATA_FILE;

public class JsonGetter {

    public static int getConfigInt(String key) {
        return Integer.parseInt(getConfigString(key));
    }

    public static String getConfigString(String key) {
        return JsonGetter.getData(TEST_DATA_FILE, String.format(KEY_FORMAT, key));
    }

    private static String getData(String file, String value) {
        return new JsonSettingsFile(file).getValue(value).toString();
    }
}
