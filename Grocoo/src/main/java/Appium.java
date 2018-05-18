import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Appium {
     AppiumDriver driver;

    @Before
    public void setupTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Emulator");
//        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("automationName","appium");
        capabilities.setCapability("appPackage","com.grocoo.customer");
        capabilities.setCapability("appActivity","com.grocoo.customer.MainActivity");
//        capabilities.setCapability("app", "C:/Vinoth-Repo/VinothRepo/Grocoo/com.facebook.katana_2018-05-05.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        AppiumDriver<MobileElement> driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
}
