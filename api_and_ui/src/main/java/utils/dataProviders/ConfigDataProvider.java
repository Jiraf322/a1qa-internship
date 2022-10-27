package utils.dataProviders;

import utils.JsonGetter;
import static testData.TestConstants.*;

public class ConfigDataProvider {

    public static String getBaseUrl() {
        return JsonGetter.getStringData(BASE_URL_KEY);
    }

    public static String getUserId() {
        return JsonGetter.getStringData(USER_ID_KEY);
    }

    public static String getPhotoPath() {
        return JsonGetter.getStringData(PHOTO_PATH_KEY);
    }

    public static int getLengthForRandomString() {
        return JsonGetter.getIntData(LENGTH_FOR_RANDOM_STRING_KEY);
    }

    public static String getActualPhotoPath() {
        return JsonGetter.getStringData(ACTUAL_PHOTO_PATH_KEY);
    }
}
