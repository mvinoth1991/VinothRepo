package com.vinoth.test.steps;

import com.vinoth.test.pages.AfterLoginPage;
import com.vinoth.test.pages.HOOQHomePage;
import com.vinoth.test.pages.HomePage;
import com.vinoth.test.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.yecht.Data;

import java.sql.Timestamp;
import java.util.HashMap;


public class SignUpScenariosSteps {


    //UserSteps user;
    HomePage homePage ;
    LoginPage loginPage;
    HOOQHomePage hooqHomePage;
    AfterLoginPage afterLoginPage;

    WebDriver driver;
    //HOOQHomePage hooqHomePage = new HOOQHomePage();
    HashMap map= new HashMap();


    @Given("^I have user details for sign in$")
    public void iHaveUserDetailsForSignUpEmailPasswordName() throws Throwable {
      //  homePage.openBrowser();
        homePage.open();
        homePage.clickOnLogin();
    }

    @And("^user should be able to sign up successfully(.*)(.*)$")
    public void userShouldBeAbleToSignUpSuccessfully(String fname, String lname) throws Throwable {
        afterLoginPage.verifyLoggedin(fname,lname);
        afterLoginPage.sigOut();
        throw new PendingException();
    }

    @When("^I click on register new account (.*)$")
    public void iClickOnRegisterNewAccountEmailID(String ID) throws Throwable {
        loginPage.enterSignupEmailID(ID);
        loginPage.clickOnCreateAccount();
        //throw new PendingException();
    }


    @Then("^I should be able to enter details for registration (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) account page$")
    public void iShouldBeAbleToEnterDetailsForRegistration(String gender, String fname, String lname, String pwd, String day, String month, String year,String city,
                                                           String country, String state) throws Throwable {
        hooqHomePage.verifyUIElements();
        hooqHomePage.selectRadioButton(gender);
        hooqHomePage.enterFirstName(fname);
        hooqHomePage.enterLastName(lname);
        hooqHomePage.enterPassword(pwd);
        hooqHomePage.enterDay(day);
        hooqHomePage.enterMonth(month);
        hooqHomePage.enterYear(year);
        hooqHomePage.enterAddress();
        hooqHomePage.enterCity(city);
        hooqHomePage.enterState(state);
        hooqHomePage.enterPostalCode();
        hooqHomePage.enterCountry(country);
        hooqHomePage.enterMobileNumber();
        hooqHomePage.enterAliasAddress();
        hooqHomePage.clickOnRegister();
        //throw new PendingException();
    }

    @Then("^verify user is logged in successfully (.*) (.*) $")
    public void verifyUserIsLoggedInSuccessfully(String fname,String lname) throws Throwable {
        afterLoginPage.verifyLoggedin(fname,lname);
        afterLoginPage.sigOut();
        //throw new PendingException();
    }

}
