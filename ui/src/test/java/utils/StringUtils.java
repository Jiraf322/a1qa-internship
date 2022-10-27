package utils;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;

public class StringUtils {

    public static String removeAllDigit(String str) {
        return str.replaceAll("\\d", "");
    }

    public static CharacterRule getLowerCaseRule() {
        return new CharacterRule(EnglishCharacterData.LowerCase);
    }

    public static CharacterRule getUpperCaseRule() {
        return new CharacterRule(EnglishCharacterData.UpperCase);
    }

    public static CharacterRule getDigitRule() {
        return new CharacterRule(EnglishCharacterData.Digit);
    }
}
