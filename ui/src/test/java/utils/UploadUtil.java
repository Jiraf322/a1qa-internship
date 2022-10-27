package utils;

import aquality.selenium.browser.AqualityServices;
import testdata.TestDataProvider;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadUtil {

    public static void uploadFile(String path) {
        File file = new File("");
        File dir = new File(String.format("%s%s", file.getAbsoluteFile(), path));
        StringSelection sel = new StringSelection(dir.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            AqualityServices.getLogger().debug(String.format("Robot is not started due to:\n%s", e.getMessage()));
        }
        if (robot != null) {
            robot.delay(TestDataProvider.getRobotDelay());
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(TestDataProvider.getRobotDelay());
        }
        else {
            AqualityServices.getLogger().debug("Robot is null");
        }
    }
}