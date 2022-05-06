package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
public class Activity8 {
    private WebDriver driver;

    Properties obj = new Properties();
    By username = By.xpath("//input[@id='user_name']");
    By password = By.xpath("//input[@id='username_password']");
    By login = By.xpath("//input[@id='bigbutton']");
    By dashboard = By.xpath("(//a[contains(text(),'SUITECRM DASHBOARD')])[1]");
    By sales = By.xpath("(//a[contains(text(),'Sales')])[1]");
    By accounts = By.xpath("(//a[contains(text(),'Sales')])[1]/..//ul/li//a[contains(text(),'Accounts')]");
    By infoIcon = By.xpath("(//span[@class='suitepicon suitepicon-action-info'])[1]");
    By tableElements = By.xpath("//tr[@class='oddListRowS1']/td[3]//a");


    public Activity8() {
        this.driver = driver;
    }
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        String baseUrl = "https://alchemy.hguy.co/crm/";
        System.out.println("Starting Test On Firefox Browser");
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void validateHomePageTest() {
        System.out.println("Entering 'admin' as username");
        driver.findElement(username).sendKeys("admin");
        System.out.println("Entering 'pa$$w0rd' as password");
        driver.findElement(password).sendKeys("pa$$w0rd");
        System.out.println("hitting login button");
        driver.findElement(login).click();

        Boolean result = driver.findElement(dashboard).isDisplayed();
        assertTrue(result,"Homepage validation.");
    }
    @Test(dependsOnMethods = {"validateHomePageTest"})
    public void printFirstFiveNamesTest() throws InterruptedException {
        driver.findElement(sales).click();
        Thread.sleep(500);
        driver.findElement(accounts).click();
        // Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableElements));

        List<WebElement> listElements = driver.findElements(tableElements);
        for(int i=0;i<5;i++) {
            String value =  listElements.get(i).getText();
            assertTrue(value != "" & value != null, "Names are : ");
            System.out.println(value);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Finished Test On Firefox Browser");
    }
}
