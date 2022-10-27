package tests.base;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
