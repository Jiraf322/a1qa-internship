package forms.gamepageforms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Random;

public class LoginForm extends Form{

    public LoginForm() {
        super(By.className("login-form"), "Login Form");
    }

    private final ITextBox txbPassword = getElementFactory().getTextBox(
            By.xpath("//input[@placeholder = 'Choose Password']"), "Text box Password");
    private final ITextBox txbEmail = getElementFactory().getTextBox(
            By.xpath("//input[@placeholder = 'Your email']"), "Text box Email");
    private final ITextBox txbDomain = getElementFactory().getTextBox(
            By.xpath("//input[@placeholder = 'Domain']"), "Text box Domain");
    private final ICheckBox chbTerms = getElementFactory().getCheckBox(
            By.xpath("//span[contains(@class,'icon-check')]"), "Checkbox Terms & Conditions");
    private final IButton btnNext = getElementFactory().getButton(
            By.xpath("//a[@class = 'button--secondary']"), "Button Next");
    private final IButton btnOther = getElementFactory().getButton(
            By.xpath("//div[contains(@class, 'dropdown') and contains(@class, 'field')]"), "Dropdown Other");
    private final List<ILabel> DomainsList = getElementFactory().findElements(
            By.xpath("//div[contains(@class, 'list-item') and not(contains(@class, 'selected'))]"),
            ElementType.LABEL, ElementsCount.MORE_THEN_ZERO, ElementState.EXISTS_IN_ANY_STATE);

    public void sendPassword(String password) {
        txbPassword.clearAndType(password);
    }

    public void sendEmail(String email) {
        txbEmail.clearAndType(email);
    }

    public void sendDomain(String domain) {
        txbDomain.clearAndType(domain);
    }

    public void clickChbTerms() {
        chbTerms.click();
    }

    public void clickBtnNext() {
        btnNext.click();
    }

    public void clickBtnOther() {
        btnOther.click();
    }

    public void clickRandomDomain() {
        DomainsList.get(new Random().nextInt(DomainsList.size())).click();
    }
}
