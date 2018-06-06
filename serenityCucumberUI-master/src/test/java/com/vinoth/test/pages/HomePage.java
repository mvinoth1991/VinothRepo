package com.vinoth.test.pages;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://automationpractice.com/index.php")
public class HomePage extends PageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;



    String URL= "http://automationpractice.com/index.php";
    @FindBy(xpath = "//a[@class='login']")
    @CacheLookup
    private WebElement login;

    private final String pageLoadedText = "Create an account";
    private final String pageUrl = "http://automationpractice.com/index.php";

    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public HomePage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public HomePage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Other Sign In Options Link.
     *
     * @return the HomePage class instance.
     * @param
     */
    public HomePage clickOnLogin() {
//       Actions action = new Actions(driver);
//       action.moveToElement(login).build().perform();
//        closeAd.click();
        login.isDisplayed();
        login.click();
        return this;
    }

    public HomePage openBrowser(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return this;
        }

    /**
     * Verify that the page loaded completely.
     *
     * @return the HomePage class instance.
     */
    public HomePage verifyPageLoaded() {

        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the HomePage class instance.
     */
    public HomePage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}

