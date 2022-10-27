package forms.gamepageforms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import testdata.TestDataProvider;
import java.util.List;
import java.util.Random;

public class AvatarAndInterestsForm extends Form {

    public AvatarAndInterestsForm() {
        super(By.xpath("//div[contains(@class ,'interests') and contains(@class, 'form')]"),
                "Avatar And Interests Form");
    }

    final String RAW_LOCATOR_TO_GET_TEXT = "/ancestor::div[1]//span[text()]";
    private final ICheckBox chbUnselectAll = getElementFactory().getCheckBox(
            By.xpath("//label[@for='interest_unselectall']"), "Checkbox unselect all");
    private final IButton btnUpload = getElementFactory().getButton(
            By.xpath("//a[contains(text(), 'upload')]"), "Button upload");
    private final IButton btnNext = getElementFactory().getButton(
            By.xpath("//button[text()='Next']"), "Button Next");
    private final ILabel image = getElementFactory().getLabel(By.xpath(
            "//div[contains(@class, 'avatar-image')]"), "Uploaded image");
    private final List<ICheckBox> interestsList = getElementFactory().findElements(
            By.xpath("//span[@class='checkbox__box']"), ElementType.CHECKBOX, ElementsCount.MORE_THEN_ZERO,
            ElementState.DISPLAYED);

    public void clickChbUnselectAll() {
        chbUnselectAll.getMouseActions().moveMouseToElement();
        chbUnselectAll.click();
    }

    private String getRawLocator(ICheckBox element) {
        return element.getLocator().toString().split(" ")[1];
    }

    private ILabel getLabelFromCheckBox(ICheckBox element) {
        String locatorOfLabel = getRawLocator(element) + RAW_LOCATOR_TO_GET_TEXT;
        return getElementFactory().getLabel(By.xpath(locatorOfLabel), "Final Label");
    }

    public void chooseInterestsInInterestsList() {
        List<ICheckBox> interests = interestsList;
        for (int i = 0; i < TestDataProvider.getNumberOfInterests(); i++) {
            int index = new Random().nextInt(interests.size());
            ICheckBox interest = interests.get(index);
            interests.remove(interest);
            String textOfCheckbox = getLabelFromCheckBox(interest).getText();
            if (!textOfCheckbox.equals(TestDataProvider.getSelectAll())
                    && !textOfCheckbox.equals(TestDataProvider.getUnselectAll())) {
                interest.getMouseActions().moveMouseToElement();
                interest.click();
            } else {
                i--;
            }
        }
    }

    public void clickBtnUpload() {
        btnUpload.click();
    }

    public boolean isImageUploaded() {
        return image.state().isExist();
    }

    public void clickBtnNext() {
        btnNext.getMouseActions().moveMouseToElement();
        btnNext.click();
    }
}
