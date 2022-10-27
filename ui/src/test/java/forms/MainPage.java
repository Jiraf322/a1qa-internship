package forms;

import aquality.selenium.elements.interfaces.ILink;
import org.openqa.selenium.By;
import aquality.selenium.forms.Form;

public class MainPage extends Form {

    public MainPage() {
        super(By.xpath("//button[contains(@class, 'start')]"), "Main Page");
    }

    private final ILink btnHere = getElementFactory().getLink(
            By.xpath("//a[contains(@class, 'start') and contains(@class, 'link')]"), "Link HERE");

    public void clickHere(){
        btnHere.click();
    }
}