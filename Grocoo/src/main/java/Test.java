import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test extends Appium {
    @org.junit.Test
    public void myTest() {
        // Click on username and enter uname
        System.out.println(driver.getContext());
//        WebElement sevenKey = driver.findElement(By.xpath("//*[contains(@resource-id,'com.android.calculator2:id/digit_7')]"));
        WebElement username = driver.findElement(By.id("com.facebook.katana:id/(name removed)"));
        System.out.println(username);
        username.click();
        username.sendKeys("97804538");
        //Click on Password and enter password
        WebElement password = driver.findElement(By.id("com.facebook.katana:id/(name removed)"));
        System.out.println(password);
        password.click();
        password.sendKeys("test1234");
        // Click on '+'
        WebElement plusKey = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'buttonPlus')]"));
        plusKey.click();
        // Click on number 5
        WebElement fiveKey = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'button5')]"));
        fiveKey.click();
        // Click on '='
        WebElement equalsKey = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'buttonEquals')]"));
        equalsKey.click();
        // Check the total is correct
        WebElement total = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'textField')]"));
        String totalValue = total.getText();
        Assert.assertTrue(totalValue.equals("12"));
    }
}
