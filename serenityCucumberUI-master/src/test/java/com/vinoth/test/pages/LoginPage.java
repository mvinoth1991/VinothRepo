package com.vinoth.test.pages;

import jline.internal.Log;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

@FindBy(xpath = "//img[@id='logoImage']")
@CacheLookup
    private WebElement loginLogo;

@FindBy(id = "j_username")
    @CacheLookup
    private WebElement userNameTextField;

@FindBy(id="j_password")
    private WebElement pwdTextField;

@FindBy(className = "btn")
    private WebElement signinButton;

@FindBy(xpath = "//li[@class='nav-logout']")
private WebElement logoutBtn;

@FindBy(xpath = "//a[@name='login-user-name']")
private WebElement assertLoginName;

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
    return this;
}

public LoginPage verifySignIn(String ID)
{
    Log.info("Verifying login ");
    shouldNotBeVisible(signinButton);
    shouldBeVisible(logoutBtn);
    assertLoginName.getText().contains(ID);
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
