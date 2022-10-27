package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import utils.dataProviders.ConfigDataProvider;
import org.openqa.selenium.By;

import static testData.TestConstants.SRC_ATTRIBUTE;

public class MyPage extends Form {

    private final String LABEL_OF_COMMENTS = "//div[contains(@id, '%s') and contains(@id, '%s')]//div[contains(@class," +
            " 'wall_reply_text')]";
    private final String BUTTON_LIKE_OF_POST = "//div[@data-reaction-target-object = 'wall%s_%s']";

    public MyPage() {
        super(By.id("profile"), "My page");
    }

    private final ILink image = getElementFactory().getLink(By.xpath("//div[@id='pv_photo']/img"), "Image");
    private final IButton btnClosePost = getElementFactory().getButton(By.xpath("//div[@class = 'pv_close_btn']"),
            "Button close opened post");

    public ILabel getLabelOfPost(String userId, String postId) {
        return getElementFactory().getLabel(By.id(String.format("wpt%s_%s", userId, postId)), String.format("post with" +
                "id: %s, created by user with id: %s", postId, userId));
    }

    public IButton getButtonLikeOfPost(String userId, String postId) {
        return getElementFactory().getButton(By.xpath(String.format(BUTTON_LIKE_OF_POST,
                userId, postId)), String.format("button like from post with id: %s, created by user with id: %s",
                postId, userId));
    }

    public Boolean isUserInPostCorrect(ILabel labelOfPost, String userId) {
        return labelOfPost.getLocator().toString().contains(userId);
    }

    public ILabel getLabelOfComment(String postId, String userId) {
        return getElementFactory().getLabel(By.xpath(String.format(LABEL_OF_COMMENTS, postId, userId)), String.format(
                "label of comment on the post with id: %s, created by user with id: %s", postId, userId));
    }

    public void clickButtonShowComments(String userId, String postId) {
        getElementFactory().getButton(By.xpath(String.format("//a[@href = '/wall%s_%s']//span[contains(@class, 'next_label')]",
                userId, postId)), "show comments button").click();
    }

    public ILabel getPhotoFromPost(String postId, String photoId) {
        return getElementFactory().getLabel(By.xpath(String.format("//div[@id='post%s_%s']//a[@href='/photo%s_%s']",
                ConfigDataProvider.getUserId(), postId, ConfigDataProvider.getUserId(), photoId)), String.format("photo" +
                "with id: %s", photoId));
    }

    public String getImageSrcAttribute() {
        return image.getAttribute(SRC_ATTRIBUTE);
    }

    public void clickAndWaitPhotoFromPost(String postId, String photoId) {
        getPhotoFromPost(postId, photoId).clickAndWait();
    }

    public void clickButtonClosePost() {
        btnClosePost.click();
    }
}