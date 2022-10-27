package utils.dataProviders;

import aquality.selenium.browser.AqualityServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Credentials;
import testData.TestConstants;
import java.io.File;
import java.io.IOException;

public class DataProvider {

    public static Credentials getCredentials() {
        try {
            return new ObjectMapper().readValue(new File(TestConstants.CREDENTIALS_FILE_PATH), Credentials.class);
        } catch (IOException e) {
            AqualityServices.getLogger().error(String.format("Unable to get value due to: \n%s", e));
            throw new RuntimeException(e);
        }
    }
}
