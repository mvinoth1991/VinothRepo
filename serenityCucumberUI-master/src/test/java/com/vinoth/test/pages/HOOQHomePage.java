package com.vinoth.test.pages;

import jline.internal.Log;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.sql.Timestamp;
import java.util.List;

public class HOOQHomePage extends PageObject {

    private static String personalInfoSection="Your personal information";
    private static String addressSection="Your personal information";

    @FindBy(id = "uniform-id_gender1")
    private WebElement genderRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameTextBox;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameTextBox;

    @FindBy(id = "email")
    private WebElement selectTopStory;

    @FindBy(id = "passwd")
    private WebElement passwordTextbox;

    @FindBy(id = "days")
    private WebElement daysDropDown;

    @FindBy(id = "account_creation")
    private WebElement accountCreationSection;

    @FindBy(id = "months")
    @CacheLookup
    private WebElement monthsDropDown;

    @FindBy(id="years")
    private WebElement yearsDropDown;

    @FindBy(id = "account-creation_form")
    private WebElement personalInfoForm;

    LoginPage loginPage = new LoginPage();

    public HOOQHomePage verifyUIElements(){
        personalInfoForm.isDisplayed();
        accountCreationSection.isDisplayed();
        accountCreationSection.getText().contains(personalInfoSection);
        accountCreationSection.getText().contains(addressSection);
        return this;
    }

    public HOOQHomePage selectRadioButton(String gender){
        genderRadioButton.isDisplayed();
        switch (gender){
            case "Mr":
            break;
            case "Mrs":
            genderRadioButton.click();
            break;
    }
        return this;
    }

    public static String getRandomNumber() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long randomLong=timestamp.getTime();
        return String.valueOf(randomLong);
    }
    public HOOQHomePage enterFirstName(String firstName)
    {
        Log.info("Entering first name");
        firstNameTextBox.isDisplayed();
        firstNameTextBox.click();
        firstNameTextBox.sendKeys(firstName+getRandomNumber().substring(3));
        return this;
    }

    public HOOQHomePage enterLastName(String lastName)
    {
        Log.info("Entering last name ");
        lastNameTextBox.isDisplayed();
        lastNameTextBox.click();
        lastNameTextBox.sendKeys(lastName+getRandomNumber().substring(3));
        return this;
    }

    public HOOQHomePage enterPassword(String password) {
        Log.info("Entering password");
        passwordTextbox.isDisplayed();
        passwordTextbox.click();
        passwordTextbox.sendKeys(password);
        return this;
    }

    public HOOQHomePage enterDay(String day){//23
        Select days= new Select(daysDropDown);
        days.selectByVisibleText(day);
        return this;
    }

    public HOOQHomePage enterMonth(String month){//June
        Select months= new Select(monthsDropDown);
        months.selectByVisibleText(month);
        return this;
    }

    public HOOQHomePage enterYear(String year){//1991
        Select years= new Select(yearsDropDown);
        years.selectByVisibleText(year);
        return this;
    }

}
