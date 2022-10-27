package utils;

public class StringUtils {

    public static String getStringWithoutBrackets(String str) {
        return str.replaceAll("\\[", "").replaceAll("]","");
    }
}
