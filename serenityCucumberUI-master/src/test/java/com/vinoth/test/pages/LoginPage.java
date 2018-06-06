package com.vinoth.test.pages;

import jline.internal.Log;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Timestamp;

public class LoginPage extends PageObject {


    private String enteredEmailid;
    @FindBy(xpath = "//li[@class='nav-logout']")
    private WebElement logoutBtn;


    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailTextBox;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement alertDangerMsg;

    public static String alertMsg="An account using this email address has already been registered. Please enter a valid password or request a new one. ";
    public static String getRandomNumber() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long randomLong=timestamp.getTime();
        return String.valueOf(randomLong);
    }

public LoginPage enterEmailID(String emailID)
{
    Log.info("Entering ID in Username field");
    emailTextBox.isDisplayed();
    this.enteredEmailid= emailID+getRandomNumber().substring(3)+"@gmail.com";
    emailTextBox.sendKeys(enteredEmailid);
    Log.info("ID entered successfully");
    return this;
}

public LoginPage clickOnCreateAccount()
{
    Log.info("Clicking on submit button");
    createAnAccountBtn.isDisplayed();
    createAnAccountBtn.click();
    if(alertDangerMsg.getText().equals(alertMsg)){
        Log.info("You may have multiple browser windows open using the same identity, or\n" +
                "    someone someone has already reqisterd using your email id.");
    }
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
