package com.vinoth.test.pages;
import java.util.Map;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://www.straitstimes.com/")
public class HomePage extends PageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;



    String URL= "http://www.straitstimes.com/";
    @FindBy(xpath = "//li[@class='nav-login']")
    @CacheLookup
    private WebElement login;

    @FindBy(xpath = "//button[@class='animated fadeIn']")
    private WebElement closeAd;

    private final String pageLoadedText = "The Straits Times";
    private final String pageUrl = "http://www.straitstimes.com/";

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
        login.click();
        return this;
    }

    public HomePage openBroserAndCloseAd(){
        driver=getDriver();
        getDriver().navigate().to(URL);
        driver.manage().window().maximize();
        //int size = driver.findElements(By.tagName("iframe")).size();
        //System.out.println(size);
       try{
        WebElement frame=driver.findElement(By.xpath("//div[@id='eyeDiv']/div/iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@id=\"close-button\"]")).click();
        driver.switchTo().defaultContent();
       }
       catch (Exception e){
       }
        //driver.switchTo().frame(driver.findElement(By.id("click-through-button")));
       // driver.findElement(By.id("close-button")).click(); //Close Ad
        //driver.switchTo().defaultContent(); // Return to main window
        return  this;
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

