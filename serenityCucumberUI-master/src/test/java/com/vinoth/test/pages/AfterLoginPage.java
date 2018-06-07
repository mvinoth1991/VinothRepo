package com.vinoth.test.pages;


import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterLoginPage extends HOOQHomePage {

    @FindBy(xpath = "//*[contains(@class, 'header_user_info')]//*[contains(@title, 'View my customer account')]")//get text to verify login
    private WebElement loggedInUserName;

    @FindBy(xpath = "//*[contains(@class, 'header_user_info')]//*[contains(@title, 'Log me out')]")//click to logout
    private WebElement signOutButton;

    public AfterLoginPage verifyLoggedin(String fname, String lname){
        signOutButton.isDisplayed();
        String inputUsername = fname.replace(" ","")+lname.replace(" ","");
        String userName = loggedInUserName.getText();
        String newUsername = userName.replace(" ","");
        //newUsername.contains(inputUsername);
        Assert.assertEquals(newUsername.toLowerCase(),inputUsername.toLowerCase());
        return this;
    }

    public AfterLoginPage sigOut(){
        signOutButton.isDisplayed();
        signOutButton.click();
        return this;
    }
}
