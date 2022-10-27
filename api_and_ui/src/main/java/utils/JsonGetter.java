package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;
import static testData.TestConstants.KEY_FORMAT;
import static testData.TestConstants.TEST_DATA_FILE_NAME;

public class JsonGetter {

    public static int getIntData(String key) {
        return Integer.parseInt(getStringData(key));
    }

    public static int getIntData(String file, String key) {
        return Integer.parseInt(getStringData(file, key));
    }

    public static String getStringData(String file, String key) {
        return JsonGetter.getData(file, String.format(KEY_FORMAT, key));
    }

    public static String getStringData(String key) {
        return JsonGetter.getData(TEST_DATA_FILE_NAME, String.format(KEY_FORMAT, key));
    }

    private static String getData(String file, String value) {
        return new JsonSettingsFile(file).getValue(value).toString();
    }
}