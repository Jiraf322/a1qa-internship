package utils;

import java.util.Random;

public final class RandomUtils {

    private RandomUtils() {
    }

    private static final String ALPHA_NUMERIC_ALPHABET =  " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIKLMNOPQRSTUVWXYZ";

    public static String getRandomString(int length) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            str.append(ALPHA_NUMERIC_ALPHABET.charAt(random.nextInt(ALPHA_NUMERIC_ALPHABET.length())));
        }
        return str.toString();
    }
}
