package com.vinoth.test.steps;

import com.vinoth.test.pages.HomePage;
import com.vinoth.test.pages.LoginPage;
import com.vinoth.test.pages.StraitTimesHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Timestamp;
import java.util.HashMap;

public class SignInScenariosSteps {

    @Steps
    //UserSteps user;
    HomePage homePage ;
    LoginPage loginPage;
    StraitTimesHomePage straitTimesHomePage;


    WebDriver driver;

    HashMap map= new HashMap();


    @Given("^I have user details for sign in$")
    public void iHaveUserDetailsForSignUpEmailPasswordName() throws Throwable {
        homePage.openBrowser();
        homePage.clickOnLogin();
    }

    @When("^I click on register new account (.*)$")
    public void iClickOnLoginIDPassword(String ID) throws Throwable {
        loginPage.enterEmailID(ID);
        loginPage.clickOnCreateAccount();
    }

    @Then("^I should be able to see my (.*) account page$")
    public void iShouldBeAbleToSeeMyIDAccountPage(String ID) throws Throwable {
        straitTimesHomePage.verifySignIn(ID);
        straitTimesHomePage.selectTopStory();
        straitTimesHomePage.verifyVideoAndImage();
        loginPage.clickOnLogout();
    }

     public static String getRandomNumber() {
       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       long randomLong=timestamp.getTime();
       return String.valueOf(randomLong);
   }
}
