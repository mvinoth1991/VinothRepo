import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test extends Appium {
    @org.junit.Test
    public void myTest() {
        // Click on number 7
        WebElement sevenKey = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'button7')]"));
        sevenKey.click();
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
