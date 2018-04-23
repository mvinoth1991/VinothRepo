package com.vinoth.test.pages;

import jline.internal.Log;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class StraitTimesHomePage extends LoginPage {

    @FindBy(xpath = "//li[@class='nav-logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//a[@name='login-user-name']")
    private WebElement assertLoginName;

    @FindBy(xpath = "//a[@class='block-link'][1]")
    private WebElement selectTopStory;

    @FindBy(xpath = "//div[@class='ytp-cued-thumbnail-overlay-image']")
    private WebElement videoElementVisible;

    @FindBy(xpath = "//figure[@class='image file-media-original media-element']")
    private WebElement imageElementVisible;

    @FindBy(xpath = "//img[@id='logoImage']")
    @CacheLookup
    private WebElement loginLogo;

    public StraitTimesHomePage verifySignIn(String ID)
    {
        Log.info("Verifying login ");
        shouldNotBeVisible(loginLogo);
        shouldBeVisible(logoutBtn);
        assertLoginName.getText().contains(ID);
        return this;
    }

    public StraitTimesHomePage selectTopStory()
    {
        Log.info("Trying to click on TopStory ");
        selectTopStory.isDisplayed();
        selectTopStory.click();
        return this;
    }

    public StraitTimesHomePage verifyVideoAndImage() {
        Log.info("Trying to verify video and image elements");
        waitFor(videoElementVisible);
        shouldBeVisible(videoElementVisible);
        shouldBeVisible(imageElementVisible);
        return this;
    }

}
