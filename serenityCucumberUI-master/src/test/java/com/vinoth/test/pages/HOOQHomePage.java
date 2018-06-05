package com.vinoth.test.pages;

import com.sun.java.util.jar.pack.Instruction;
import jline.internal.Log;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HOOQHomePage extends LoginPage {

    private static String personalInfoSection="Your personal information";
    private static String addressSection="Your personal information";

    @FindBy(id = "uniform-id_gender1")
    private WebElement genderRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement selectTopStory;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "uniform-days")
    private WebElement imageElementVisible;

    @FindBy(className = "account_creation")
    private WebElement accountCreationSection;

    @FindBy(xpath = "//img[@id='logoImage']")
    @CacheLookup
    private WebElement loginLogo;

    @FindBy(id = "account-creation_form")
    private WebElement personalInfoForm;

    LoginPage loginPage = new LoginPage();

    public HOOQHomePage verifyUIElements(){
        personalInfoForm.isDisplayed();
        accountCreationSection.isDisplayed();
        accountCreationSection.getText().contains(personalInfoSection);
        accountCreationSection.getText().contains(addressSection);
        return this;
    }

    public HOOQHomePage selectRadioButton(String gender){
        genderRadioButton.isDisplayed();
        switch (gender){
            case "Mr":
            break;
            case "Mrs":
            genderRadioButton.click();
            break;
    }
        return this;
    }
    public HOOQHomePage verifySignIn(String ID)
    {
        Log.info("Verifying login ");
        shouldNotBeVisible(loginLogo);
        shouldBeVisible(logoutBtn);
        assertLoginName.getText().contains(ID);
        return this;
    }

    public HOOQHomePage selectTopStory()
    {
        Log.info("Trying to click on TopStory ");
        selectTopStory.isDisplayed();
        selectTopStory.click();
        return this;
    }

    public HOOQHomePage verifyVideoAndImage() {
        Log.info("Trying to verify video and image elements");
        waitFor(videoElementVisible);
        shouldBeVisible(videoElementVisible);
        shouldBeVisible(imageElementVisible);
        return this;
    }

}
