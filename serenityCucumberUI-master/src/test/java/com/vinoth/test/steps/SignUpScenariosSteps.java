package com.vinoth.test.steps;

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

import java.sql.Timestamp;
import java.util.HashMap;


public class SignUpScenariosSteps {


    //UserSteps user;
    HomePage homePage ;
    LoginPage loginPage;
    HOOQHomePage hooqHomePage;


    WebDriver driver;

    HashMap map= new HashMap();


    @Given("^I have user details for sign in$")
    public void iHaveUserDetailsForSignUpEmailPasswordName() throws Throwable {
        homePage.openBrowser();
        homePage.clickOnLogin();
    }
    
    @Then("^I should be able to enter details for registration <gender> <fname><lname><pwd><day><month><year> account page$")
    public void iShouldBeAbleToEnterDetailsForRegistrationGenderFnameLnamePwdDayMonthYearAccountPage(String gender, String fname, String lname, String pwd, String day, String month, String year) throws Throwable {
        hooqHomePage.verifyUIElements();
        hooqHomePage.selectRadioButton(gender);
        hooqHomePage.enterFirstName(fname);
        hooqHomePage.enterLastName(lname);
        hooqHomePage.enterPassword(pwd);
        hooqHomePage.enterDay(day);
        hooqHomePage.enterMonth(month);
        hooqHomePage.enterYear(year);
        throw new PendingException();
    }

    @And("^user should be able to sign up successfully$")
    public void userShouldBeAbleToSignUpSuccessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on register new account <emailID>$")
    public void iClickOnRegisterNewAccountEmailID(String ID) throws Throwable {
        loginPage.enterEmailID(ID);
        loginPage.clickOnCreateAccount();
        throw new PendingException();
    }
}
