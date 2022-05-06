package Activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceId","61c5a16e");
        caps.setCapability("appPackage","com.android.calculator2" );
        caps.setCapability("appActivity",".Calculator" );
        caps.setCapability("noReset",true);

        URL serverURL = new URL("http://localhost:4723/wd/hub");


        driver = new AndroidDriver<>(serverURL,caps);
    }
    @Test
    public void multiplicationTest(){
       MobileElement digit5 =  driver.findElementById("digit_5");
       digit5.click();
       driver.findElementByAccessibilityId("multiply").click();
       digit5.click();
       driver.findElementByAccessibilityId("equals").click();
       String resultValue = driver.findElementById("result").getText();
        Assert.assertEquals(resultValue,"25");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
