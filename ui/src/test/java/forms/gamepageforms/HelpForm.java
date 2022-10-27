package forms.gamepageforms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    public HelpForm() {
        super(By.className("help-form"), "Help form");
    }

    private final IButton btnSend = getElementFactory().getButton(
            By.xpath("//span[@class = 'discrete']"), "Button Send");
    private final ILabel lblHelpFormHow = getElementFactory().getLabel(
            By.xpath("//h2[contains(@class, 'help-form')]"), "Label 'How can we help?'");

    public void clickSend() {
        btnSend.click();
    }

    public boolean isHelpFormHidden() {
        return lblHelpFormHow.state().waitForNotDisplayed();
    }
}
