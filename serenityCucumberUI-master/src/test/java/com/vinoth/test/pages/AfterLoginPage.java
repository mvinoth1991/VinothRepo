package com.vinoth.test.pages;


import jline.internal.Log;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AfterLoginPage extends HOOQHomePage {

    @FindBy(xpath = "//*[contains(@class, 'header_user_info')]//*[contains(@title, 'View my customer account')]")//get text to verify login
    private WebElement loggedInUserName;

    @FindBy(xpath = "//*[contains(@class, 'header_user_info')]//*[contains(@title, 'Log me out')]")//click to logout
    private WebElement signOutButton;

    public AfterLoginPage verifyLoggedin(String fname, String lname){
        try{
        if(signOutButton.isDisplayed()) {
            String inputUsername = fname.replace(" ","")+lname.replace(" ","");
            String userName = loggedInUserName.getText();
            String newUsername = userName.replace(" ","");
            //newUsername.contains(inputUsername);
            Assert.assertEquals(newUsername.toLowerCase(),inputUsername.toLowerCase());
        }}
        catch(Exception e) {
            Log.info("Username of Password entered is incorrect. Please check");
        }
        return this;
    }

    public AfterLoginPage sigOut(){
        try{
            if(signOutButton.isDisplayed()) {
                signOutButton.click();
            }}
        catch(Exception e) {
            Log.info("Username of Password entered is incorrect. Please check");
        }
        return this;
    }
}
