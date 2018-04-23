package com.vinoth.test.steps;

import com.vinoth.test.pages.HomePage;
import com.vinoth.test.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.sql.Timestamp;
import java.util.HashMap;

public class SignInScenariosSteps {

    @Steps
    //UserSteps user;
    HomePage homePage;
    LoginPage loginPage;
    HashMap map= new HashMap();


    @Given("^I have user details for sign in$")
    public void iHaveUserDetailsForSignUpEmailPasswordName() throws Throwable {
        homePage.verifyPageLoaded();
        homePage.verifyPageUrl();
        homePage.clickOnLogin();
    }

    @When("^I click on login <ID> <Password>$")
    public void iClickOnLoginIDPassword(String ID, String password) throws Throwable {
        loginPage.enterUserName(ID);
        loginPage.enterPwd(password);
        loginPage.clickOnSubmit();
        throw new PendingException();
    }

    @Then("^I should be able to see my <ID> account page$")
    public void iShouldBeAbleToSeeMyIDAccountPage(String ID) throws Throwable {
        loginPage.verifySignIn(ID);
        loginPage.clickOnLogout();
        throw new PendingException();
    }

     public static String getRandomNumber() {
       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       long randomLong=timestamp.getTime();
       return String.valueOf(randomLong);
   }
}
