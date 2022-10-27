package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class NavBar extends Form {

    public NavBar() {
        super(By.className("side_bar_nav"), "Navigation bar");
    }

    private final IButton btnMyPage = getElementFactory().getButton(By.id("l_pr"), "Button my page");

    public void clickButtonMyPage() {
        btnMyPage.click();
    }
}
