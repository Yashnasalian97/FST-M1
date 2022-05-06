package Live_Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity1 {
    AndroidDriver<MobileElement> driver;
    String Task1 = "Completed Activities with google tasks";
    String Task2 = "Completed Activity with google Keep";
    String Task3 = "Completed the second activity with google keep";


    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceId","61c5a16e");
        caps.setCapability("appPackage","com.google.android.apps.tasks" );
        caps.setCapability("appActivity",".ui.TaskListsActivity" );
        caps.setCapability("noReset",true);

        URL serverURL = new URL("http://localhost:4723/wd/hub");


        driver = new AndroidDriver<>(serverURL,caps);
    }

    @Test
    public void createTasks(){
        MobileElement addTask = driver.findElementById("tasks_fab");
        addTask.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,20);
        MobileElement add_task_title = driver.findElementById("add_task_title");
        wait.until(ExpectedConditions.elementToBeClickable(add_task_title));
        add_task_title.click();

        add_task_title.sendKeys(Task1);
driver.findElementById("add_task_done").click();

addTask = driver.findElementById("tasks_fab");
addTask.click();

        driver.findElementById("add_task_title").click();
        driver.findElementById("add_task_title").sendKeys(Task2);
        driver.findElementById("add_task_done").click();

        addTask = driver.findElementById("tasks_fab");
        addTask.click();

        driver.findElementById("add_task_title").click();
        driver.findElementById("add_task_title").sendKeys(Task3);
        driver.findElementById("add_task_done").click();
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));

        List<MobileElement> taskList = driver.findElementsById("task_name");
        for(MobileElement taskEntry:taskList){
            System.out.println(taskEntry.getText());
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
