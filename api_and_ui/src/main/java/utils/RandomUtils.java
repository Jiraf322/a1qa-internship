package utils;

import java.util.Random;

public class RandomUtils {

    private static final String ALPHABET =  " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIKLMNOPQRSTUVWXYZ";

    public static String getRandomString(int length) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            str.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return str.toString();
    }
}
