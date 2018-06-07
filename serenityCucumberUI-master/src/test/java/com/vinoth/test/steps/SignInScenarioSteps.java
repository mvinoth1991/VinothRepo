package com.vinoth.test.steps;

import com.vinoth.test.pages.AfterLoginPage;
import com.vinoth.test.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInScenarioSteps {

    LoginPage loginPage;
    AfterLoginPage afterLoginPage;

    @When("^I enter username and password (.*) (.*)$")
    public void iEnterUsernameAndPasswordEmailIDPaswd(String pwd, String emailID) throws Throwable {
        loginPage.enterSiginEmailID(emailID);
        loginPage.enterPassword(pwd);
        loginPage.clickSubmit();
        //throw new PendingException();
    }

    @Then("^verify user is logged in successfully (.*)(.*)$")
    public void verifyUserIsLoggedInSuccessfullyUsername(String fname, String lname) throws Throwable {
        afterLoginPage.verifyLoggedin(fname,lname);
        afterLoginPage.sigOut();
        //throw new PendingException();
    }
}
