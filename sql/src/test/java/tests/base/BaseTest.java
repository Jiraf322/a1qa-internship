package tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DBConnection;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        DBConnection.getInstance();
    }

    @AfterMethod
    public void afterMethod() {
        DBConnection.closeConnection();
    }
}
