package tests;

import aquality.selenium.browser.AqualityServices;
import forms.GamePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import forms.MainPage;
import testdata.TestDataProvider;
import tests.base.BaseTest;
import utils.RandomUtils;
import forms.gamepageforms.*;
import utils.UploadUtil;

public class InterfaceTest extends BaseTest {

    @Test
    public void testCase1() {
        AqualityServices.getBrowser().goTo(TestDataProvider.getUrl());

        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not opened");
        mainPage.clickHere();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Game page is not opened");

        LoginForm loginForm = new LoginForm();
        Assert.assertTrue(loginForm.state().waitForDisplayed(), "Login form is not opened");

        String randomPassword = RandomUtils.getRandomPassword();

        loginForm.sendPassword(randomPassword);
        loginForm.sendEmail(RandomUtils.getRandomEmail(randomPassword));
        loginForm.sendDomain(RandomUtils.getRandomDomain());

        loginForm.clickChbTerms();
        loginForm.clickBtnOther();
        loginForm.clickRandomDomain();
        loginForm.clickBtnNext();

        AvatarAndInterestsForm avatarAndInterestsForm = new AvatarAndInterestsForm();
        Assert.assertTrue(avatarAndInterestsForm.state().waitForDisplayed(),
                "Avatar and interests form is not opened");
        avatarAndInterestsForm.clickChbUnselectAll();
        avatarAndInterestsForm.chooseInterestsInInterestsList();
        avatarAndInterestsForm.clickBtnUpload();
        UploadUtil.uploadFile(TestDataProvider.getImagePath());
        Assert.assertTrue(avatarAndInterestsForm.isImageUploaded(), "Image is not uploaded");
        avatarAndInterestsForm.clickBtnNext();

        PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().isDisplayed(), "Personal details form is not opened");
    }

    @Test
    public void testCase2() {
        AqualityServices.getBrowser().goTo(TestDataProvider.getUrl());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main page is not opened");
        mainPage.clickHere();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "Game page is not opened");

        HelpForm helpForm = new HelpForm();
        helpForm.clickSend();
        Assert.assertTrue(helpForm.isHelpFormHidden(), "Help form is not hidden");
    }

    @Test
    public void testCase3() {
        AqualityServices.getBrowser().goTo(TestDataProvider.getUrl());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main page is not opened");
        mainPage.clickHere();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "Game page is not opened");
        gamePage.clickBtnAcceptCookies();
        Assert.assertTrue(gamePage.isBtnAcceptCookiesClose(), "Cookies is not accepted");
    }

    @Test
    public void testCase4() {
        AqualityServices.getBrowser().goTo(TestDataProvider.getUrl());
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main page is not opened");
        mainPage.clickHere();

        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "Game page is not opened");
        Assert.assertTrue(gamePage.isTimerStartFromZero(), "Timer start is not '00:00:00'");
    }
}
