package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.passay.CharacterRule;
import org.passay.PasswordGenerator;
import testdata.TestDataProvider;
import java.util.Random;

public class RandomUtils {

    public static String getRandomPassword() {
        int total = 0;
        PasswordGenerator gen = new PasswordGenerator();
        CharacterRule lowerCaseRule = StringUtils.getLowerCaseRule();
        int amountLowerChars = new Random().nextInt(1, TestDataProvider.getPasswordSize() - 1);
        lowerCaseRule.setNumberOfCharacters(amountLowerChars);
        total += amountLowerChars;
        CharacterRule upperCaseRule = StringUtils.getUpperCaseRule();
        int amountUpperChars = new Random().nextInt(1, TestDataProvider.getPasswordSize() - total);
        upperCaseRule.setNumberOfCharacters(amountUpperChars);
        total += amountUpperChars;
        CharacterRule digitRule = StringUtils.getDigitRule();
        if (total >= TestDataProvider.getPasswordSize()) {
            digitRule.setNumberOfCharacters(1);
            total++;
        }
        else {
            digitRule.setNumberOfCharacters(TestDataProvider.getPasswordSize() - total);
            total = TestDataProvider.getPasswordSize();
        }
        return gen.generatePassword(total, lowerCaseRule, upperCaseRule, digitRule);
    }

    public static String getRandomEmail(String password) {
        int emailSize = TestDataProvider.getEmailSize();
        String noDigitsPassword = StringUtils.removeAllDigit(password);
        char[] email = new char[emailSize];
        for (int i = 0; i < emailSize; i++)
        {
            email[i] = noDigitsPassword.charAt(new Random().nextInt(noDigitsPassword.length()));
        }
        return new String(email);
    }

    public static String getRandomDomain() {
        int domainSize = TestDataProvider.getDomainSize();
        return RandomStringUtils.randomAlphabetic(domainSize);
    }
}
