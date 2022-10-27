package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import utils.dataProviders.DataProvider;
import org.openqa.selenium.By;
import aquality.selenium.forms.Form;

public class LoginPage extends Form {

    public LoginPage() {
        super(By.xpath("//form[contains(@class, 'VkIdForm')]"), "Login Page");
    }

    private final ITextBox txbLogin = getElementFactory().getTextBox(By.id("index_email"), "Textbox login");
    private final IButton btnSignIn = getElementFactory().getButton(By.xpath(
            "//button[contains(@class, 'VkIdForm') and contains(@class, 'signInButton')]"), "Button sign in");

    public void sendLogin() {
        txbLogin.clearAndType(DataProvider.getCredentials().getLogin());
    }

    public void clickButtonSignIn() {
        btnSignIn.click();
    }
}
