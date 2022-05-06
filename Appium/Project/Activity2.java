package Live_Project;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity2 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceId","61c5a16e");
        caps.setCapability("appPackage","com.google.android.keep" );
        caps.setCapability("appActivity",".activities.BrowseActivity" );
        caps.setCapability("noReset",true);

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL,caps);
    }

    @Test
    public void createTNotes() {
        MobileElement newNote = driver.findElementByAccessibilityId("New text note");
        newNote.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,20);
        MobileElement addTitle = driver.findElementById("editable_title");
        wait.until(ExpectedConditions.elementToBeClickable(addTitle));
        addTitle.click();
        addTitle.sendKeys("Appium Automation Tool");
        MobileElement addNote = driver.findElementById("edit_note_text");
        addNote.click();
        addNote.sendKeys("Appium is an open-source tool for automating native, mobile web, and hybrid applications on iOS mobile, Android mobile, and Windows desktop platforms. Native apps are those written using the iOS, Android, or Windows SDKs.");
        driver.findElementByAccessibilityId("Open navigation drawer").click();

        MobileElement content = driver.findElementById("browse_note_interior_content");
        content.click();
        System.out.println("The Title and the Note added is:");
        MobileElement title = driver.findElementById("editable_title");
        System.out.println(title.getText());
        MobileElement note = driver.findElementById("edit_note_text");
        System.out.println(note.getText());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}