package tests.base;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.dataProviders.ConfigDataProvider;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        AqualityServices.getBrowser().goTo(ConfigDataProvider.getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
