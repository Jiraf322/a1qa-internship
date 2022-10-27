package testdata;

import utils.JsonGetter;

import static testdata.TestConstants.*;

public class TestDataProvider {

    public static int getDomainSize() {
        return JsonGetter.getConfigInt(DOMAIN_SIZE_KEY);
    }

    public static int getPasswordSize() {
        return JsonGetter.getConfigInt(PASSWORD_SIZE_KEY);
    }

    public static int getEmailSize() {
        return JsonGetter.getConfigInt(EMAIL_SIZE_KEY);
    }

    public static int getRobotDelay() {
        return JsonGetter.getConfigInt(ROBOT_DELAY_KEY);
    }

    public static int getNumberOfInterests() {
        return JsonGetter.getConfigInt(NUMBER_OF_INTERESTS_KEY);
    }

    public static String getStartTimerKey() {
        return JsonGetter.getConfigString(START_TIMER_KEY);
    }

    public static String getUrl() {
        return JsonGetter.getConfigString(URL_KEY);
    }

    public static String getImagePath() {
        return JsonGetter.getConfigString(IMAGE_PATH_KEY);
    }

    public static String getUnselectAll() {
        return JsonGetter.getConfigString(UNSELECT_ALL_KEY);
    }

    public static String getSelectAll() {
        return JsonGetter.getConfigString(SELECT_ALL_KEY);
    }
}
