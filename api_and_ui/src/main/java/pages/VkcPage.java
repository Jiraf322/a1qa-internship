package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import utils.dataProviders.DataProvider;
import org.openqa.selenium.By;
import aquality.selenium.forms.Form;

public class VkcPage extends Form{

    public VkcPage() {
        super(By.className("vkuiAppRoot"), "Login Page");
    }

    private final ITextBox txbPassword = getElementFactory().getTextBox(By.xpath(
            "//input[@autocomplete = 'current-password']"), "Textbox password");

    private final IButton btnContinue = getElementFactory().getButton(By.xpath(
            "//span[contains(@class, 'vkuiButton') and contains(@class, 'in')]"), "Button continue");

    public void sendPassword() {
        txbPassword.clearAndType(DataProvider.getCredentials().getPassword());
    }

    public void clickButtonContinue() {
        btnContinue.click();
    }
}
