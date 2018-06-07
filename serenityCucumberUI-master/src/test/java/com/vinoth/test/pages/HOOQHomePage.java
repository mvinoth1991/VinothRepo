package com.vinoth.test.pages;

import jline.internal.Log;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
 import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.StoryContextKey.elastName;


public class HOOQHomePage extends PageObject {

    private static String personalInfoSection="Your personal information";
    private String saveLastName,saveFirstName,savePassword;

    @FindBy(id = "uniform-id_gender1")
    private WebElement genderRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameTextBox;

    @FindBy(id="firstname")
    private WebElement addressFName;

    @FindBy(id="lastname")
    private WebElement addressLName;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameTextBox;

    @FindBy(id = "email")
    private WebElement selectTopStory;

    @FindBy(id = "passwd")
    private WebElement passwordTextbox;

    @FindBy(className = "account_creation")
    private WebElement accountCreationSection;

    @FindBy(id = "account-creation_form")
    private WebElement personalInfoForm;

    @FindBy(id="city")
    private WebElement cityTextBox;

    @FindBy(id="postcode")
    private WebElement postCodeTextBox;

    @FindBy(id = "phone_mobile")
    private WebElement phoneNumber;

    @FindBy(id="address1")
    private WebElement addressTextBox;

    @FindBy(id = "alias")
    private WebElement aliasAddressTextBox;

    @FindBy(id="submitAccount")
    private WebElement registerButton;

    public String generateRandomString(int lengthOfStr) {
        String randomString = RandomStringUtils.randomAlphanumeric(lengthOfStr);
        Log.info("Randomly generate string of length "+lengthOfStr +" is - "+randomString);
        return  randomString;
    }

    public HOOQHomePage verifyUIElements(){
        waitFor(personalInfoForm);
        personalInfoForm.isDisplayed();
        accountCreationSection.isDisplayed();
        accountCreationSection.getText().contains(personalInfoSection);
        return this;
    }

    public HOOQHomePage selectRadioButton(String gender){
        genderRadioButton.isDisplayed();
        genderRadioButton.click();
        return this;
    }

    public String generateRandomInteger(int lengthOfStr) {

        String number =RandomStringUtils.randomNumeric(lengthOfStr);
        Log.info("Randomly generated integer of length "+lengthOfStr + " is - "+number);
        return number;
    }
    public HOOQHomePage enterFirstName(String firstName)
    {
        Log.info("Entering first name");
        firstNameTextBox.isDisplayed();
        firstNameTextBox.click();
        firstNameTextBox.sendKeys(firstName);
        return this;
        }

    public HOOQHomePage enterLastName(String lastName) {
        Log.info("Entering last name ");
        lastNameTextBox.isDisplayed();
        lastNameTextBox.click();
        lastNameTextBox.sendKeys(lastName);
        saveFirstName = lastName ;
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
        Select days= new Select(getDriver().findElement(By.id("days")));
        days.selectByValue(day);
        return this;
    }

    public HOOQHomePage enterMonth(String month){//June
        Select months= new Select(getDriver().findElement(By.id("months")));
        months.selectByValue(month);
        return this;
    }

    public HOOQHomePage enterYear(String year){//1991
        Select years= new Select(getDriver().findElement(By.id("years")));
        years.selectByValue(year);
        return this;
    }

    public  HOOQHomePage enterCity(String city){
        cityTextBox.isDisplayed();
        cityTextBox.click();
        cityTextBox.sendKeys(city);
        return this;
    }

    public HOOQHomePage enterAddress(){
        addressTextBox.isDisplayed();
        addressTextBox.click();
        addressTextBox.sendKeys(generateRandomString(15));
        return this;
    }

    public HOOQHomePage enterState(String state){//get the value for selecting state
        Select idState = new Select(getDriver().findElement(By.id("id_state")));
        idState.selectByValue(state);
        return this;
    }

    public HOOQHomePage enterPostalCode(){//value should not be more than 5
        postCodeTextBox.isDisplayed();
        postCodeTextBox.click();
        postCodeTextBox.sendKeys("19"+generateRandomInteger(3));
        return this;
    }

    public HOOQHomePage enterCountry(String country){//value is 21
        Select idCountry = new Select(getDriver().findElement(By.id("id_country")));
        idCountry.selectByValue(country);
        return this;
    }

    public HOOQHomePage enterMobileNumber(){
        phoneNumber.isDisplayed();
        phoneNumber.click();
        phoneNumber.sendKeys(generateRandomInteger(8));
        return this;
    }

    public  HOOQHomePage enterAliasAddress(){
        aliasAddressTextBox.isDisplayed();
        aliasAddressTextBox.click();
        aliasAddressTextBox.clear();
        aliasAddressTextBox.sendKeys(generateRandomString(15));
        return this;
    }

    public HOOQHomePage clickOnRegister(){
        registerButton.isDisplayed();
        registerButton.click();
        return this;
    }

}
