package com.vinoth.test.pages;

import jline.internal.Log;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy(xpath = "//li[@class='nav-logout']")
    private WebElement logoutBtn;

    @FindBy(id = "j_username")
    @CacheLookup
    private WebElement userNameTextField;

    @FindBy(id="j_password")
    private WebElement pwdTextField;

    @FindBy(className = "btn")
    private WebElement signinButton;

    @FindBy(xpath = "//div[@class='page-header']")
    private WebElement userAlreadySignedIn;

    String userMessage="User Name and Password are already in use";

public LoginPage enterUserName(String ID)
{
    Log.info("Entering ID in Username field");
    userNameTextField.isDisplayed();
    userNameTextField.sendKeys(ID);
    Log.info("ID entered successfully");
    return this;
}

public LoginPage enterPwd(String pwd)
{
    Log.info("Entering password in password field");
    pwdTextField.isDisplayed();
    pwdTextField.sendKeys(pwd);
    Log.info("Password is entered successfully");
    return this;
}

public LoginPage clickOnSubmit()
{
    Log.info("Clicking on submit button");
    signinButton.isDisplayed();
    signinButton.click();
    if(userAlreadySignedIn.getText().equals(userMessage)){
        Log.info("You may have multiple browser windows open using the same identity, or\n" +
                "    someone may be sharing your password.");
    }
    return this;
}


public LoginPage clickOnLogout()
{
    Log.info("Trying to click on Logout");
    shouldBeVisible(logoutBtn);
    logoutBtn.click();
    return this;
}
}
