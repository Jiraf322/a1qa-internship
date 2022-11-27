package utils;

public final class StringUtils {

    private StringUtils() {
    }

    public static String removeSquareBrackets(String str) {
        return str.replaceAll("\\[", "").replaceAll("]","");
    }
}
