package com.vinoth.test.pages;

import jline.internal.Log;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Timestamp;

public class LoginPage extends PageObject {


    private String enteredEmailid;
    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailSignUpTextBox;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailSignInTextBox;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordTextBox;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountBtn;

    @FindBy(id = "login_form")
    private WebElement signInEmailIdTextBox;

    @FindBy(id="SubmitLogin")
    private WebElement clickSubmit;

    public static String alertMsg="An account using this email address has already been registered. Please enter a valid password or request a new one. ";
    public static String getRandomNumber() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long randomLong=timestamp.getTime();
        return String.valueOf(randomLong);
    }

public LoginPage enterSignupEmailID(String emailID)
{
    Log.info("Entering ID in Username field");
    emailSignUpTextBox.isDisplayed();
    this.enteredEmailid= emailID+getRandomNumber().substring(3)+"@gmail.com";
    emailSignUpTextBox.sendKeys(enteredEmailid);
    Log.info("ID entered successfully");
    return this;
}

public LoginPage enterSiginEmailID(String enteredEmailid){
    Log.info("Entering Email ID");
    emailSignInTextBox.isDisplayed();
    emailSignInTextBox.sendKeys(enteredEmailid);
    Log.info("ID entered successfully");
    return this;
}

public LoginPage enterPassword(String password){
    Log.info("Entering Password");
    passwordTextBox.isDisplayed();
    passwordTextBox.sendKeys(password);
    Log.info("Password entered successfully");
    return this;
}

public LoginPage clickOnCreateAccount()
{
    Log.info("Clicking on Register email button");
    createAnAccountBtn.isDisplayed();
    createAnAccountBtn.click();
    return this;
}

public LoginPage clickSubmit(){
   Log.info("Click submit button");
   clickSubmit.isDisplayed();
   clickSubmit.click();
   return this;
}


public LoginPage clickOnLogout()
{
    Log.info("Trying to click on Logout");
    logoutBtn.isDisplayed();
    logoutBtn.click();
    return this;
}
}
