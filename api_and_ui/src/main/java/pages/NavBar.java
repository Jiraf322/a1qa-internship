package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class NavBar extends Form {

    private final IButton btnMyPage = getElementFactory().getButton(By.id("l_pr"), "Button my page");

    public NavBar() {
        super(By.className("side_bar_nav"), "Navigation bar");
    }

    public void clickButtonMyPage() {
        btnMyPage.click();
    }
}
