package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import aquality.selenium.forms.Form;
import testdata.TestDataProvider;

public class GamePage extends Form {

    public GamePage() {
        super(By.xpath("//div[contains(@class,'timer')]"), "Game Page");
    }

    private final IButton btnAcceptCookies = getElementFactory().getButton(
            By.xpath("//button[contains(@class,'transparent')]"), "Button accept cookies");
    private final ILabel lblTimer = getElementFactory().getLabel(
            By.xpath("//div[contains(@class,'timer')]"), "timer");

    public void clickBtnAcceptCookies() {
        btnAcceptCookies.click();
    }

    public boolean isBtnAcceptCookiesClose() {
        return !btnAcceptCookies.state().isDisplayed();
    }

    public boolean isTimerStartFromZero() {
        return lblTimer.getText().equals(TestDataProvider.getStartTimerKey());
    }
}
