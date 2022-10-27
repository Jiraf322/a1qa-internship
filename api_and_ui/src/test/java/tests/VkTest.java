package tests;

import utils.DownloadUtil;
import utils.api.UploadPhotoSteps;
import utils.dataProviders.ConfigDataProvider;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyPage;
import pages.NavBar;
import pages.VkcPage;
import tests.base.BaseTest;
import utils.ImageComparisonUtils;
import utils.RandomUtils;
import utils.api.RestApiUtils;
import utils.api.VkApiUtils;

public class VkTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final VkcPage vkcPage = new VkcPage();
    private final NavBar navBar = new NavBar();
    private final MyPage myPage = new MyPage();

    @Test
    public void testVkApiAndUi() {
        Assert.assertTrue(loginPage.state().waitForDisplayed(), String.format("%s is not opened", loginPage.getName()));

        loginPage.sendLogin();
        loginPage.clickButtonSignIn();
        Assert.assertTrue(vkcPage.state().waitForDisplayed(), String.format("%s is not opened", vkcPage.getName()));
        vkcPage.sendPassword();
        vkcPage.clickButtonContinue();
        Assert.assertTrue(navBar.state().waitForDisplayed(), String.format("%s is not displayed", navBar.getName()));

        navBar.clickButtonMyPage();
        Assert.assertTrue(myPage.state().waitForDisplayed(), String.format("%s is not opened", myPage.getName()));

        var randomStringExpected = RandomUtils.getRandomString(ConfigDataProvider.getLengthForRandomString());
        var createPostResponseActual = VkApiUtils.createPost(randomStringExpected);
        Assert.assertEquals(createPostResponseActual.getStatusCode(), HttpStatus.SC_OK, String.format("Response status is not" +
                "%s", HttpStatus.SC_OK));
        var postIdActual = RestApiUtils.getIdFromPost(createPostResponseActual);

        Assert.assertTrue(myPage.isUserInPostCorrect(myPage.getLabelOfPost(ConfigDataProvider.getUserId(), postIdActual),
                ConfigDataProvider.getUserId()));
        Assert.assertEquals(myPage.getLabelOfPost(ConfigDataProvider.getUserId(), postIdActual).getText(),
                randomStringExpected, String.format("text in post is not as expected" +
                        ": %s", randomStringExpected));

        var uploadUrlActual = UploadPhotoSteps.getUploadUrl(UploadPhotoSteps.getWallPhotoServerResponse());
        var uploadPhotoResultActual = UploadPhotoSteps.saveUploadWallPhoto(UploadPhotoSteps.uploadPhotoOnTheWall(uploadUrlActual));
        var photoIdActual = RestApiUtils.getIdFromUploadedPhoto(uploadPhotoResultActual);
        var editResponseResultActual = VkApiUtils.editPostOnTheWall(RandomUtils.getRandomString(
                ConfigDataProvider.getLengthForRandomString()), postIdActual, photoIdActual);
        Assert.assertEquals(editResponseResultActual.getStatusCode(), HttpStatus.SC_OK, String.format("Response status is not" +
                "%s", HttpStatus.SC_OK));

        myPage.clickAndWaitPhotoFromPost(postIdActual, photoIdActual);
        DownloadUtil.downloadPhoto(myPage.getImageSrcAttribute());
        Assert.assertTrue(ImageComparisonUtils.compareImages(ConfigDataProvider.getActualPhotoPath(),
                ConfigDataProvider.getPhotoPath()), "Another photo expected to be uploaded");
        ImageComparisonUtils.deleteComparedImage();

        myPage.clickButtonClosePost();
        Assert.assertNotEquals(randomStringExpected, myPage.getLabelOfPost(ConfigDataProvider.getUserId(), postIdActual)
                .getText(), "Text has not been changed");

        var createCommentResponseActual = VkApiUtils.createCommentOnPost(RandomUtils.getRandomString(
                ConfigDataProvider.getLengthForRandomString()), postIdActual);
        Assert.assertEquals(createCommentResponseActual.getStatusCode(), HttpStatus.SC_OK, String.format("Response" +
                " status is not %s", HttpStatus.SC_OK));

        myPage.clickButtonShowComments(ConfigDataProvider.getUserId(), postIdActual);
        Assert.assertTrue(myPage.getLabelOfComment(postIdActual, ConfigDataProvider.getUserId()).state().waitForDisplayed(),
                "No comment created by author");

        myPage.getButtonLikeOfPost(ConfigDataProvider.getUserId(), postIdActual).click();

        Assert.assertTrue(VkApiUtils.isPostLikedByAuthor(postIdActual), String.format("Post with" +
                "id: %s is not liked by User with id: %s", postIdActual, ConfigDataProvider.getUserId()));

        Assert.assertEquals(VkApiUtils.deletePost(postIdActual).getStatusCode(), HttpStatus.SC_OK, String.format("Response" +
                " status is not %s", HttpStatus.SC_OK));

        Assert.assertTrue(myPage.getLabelOfPost(ConfigDataProvider.getUserId(), postIdActual).state().waitForNotDisplayed(),
                "Created post is not deleted");
    }
}
