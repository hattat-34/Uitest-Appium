package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    protected AppiumDriver<MobileElement> driver;

    @BeforeSuite
    protected void Setup() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("deviceName", "Nexus_S_API_28");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9.0");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("appPackage", "com.geovisiongroup.visiongo");
        cap.setCapability("appActivity", "com.geovisiongroup.visiongo.MainActivity");
        cap.setCapability("noReset", true);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    @AfterSuite
    protected void TearDown() {
        driver.quit();
    }
}
