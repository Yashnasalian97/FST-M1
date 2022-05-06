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

public class Activity9 {
    private WebDriver driver;

    Properties obj = new Properties();
    By username = By.xpath("//input[@id='user_name']");
    By password = By.xpath("//input[@id='username_password']");
    By login = By.xpath("//input[@id='bigbutton']");
    By dashboard = By.xpath("(//a[contains(text(),'SUITECRM DASHBOARD')])[1]");
    By sales = By.xpath("(//a[contains(text(),'Sales')])[1]");
    By lead = By.xpath("(//a[contains(text(),'Sales')])[1]/..//ul/li//a[contains(text(),'Lead')]");
    By tableElements = By.xpath("//table[@class='list view table-responsive']//tr");
    By tableColoumName = By.xpath("//table[@class='list view table-responsive']//tr//td[3]");
    By tableColoumUser = By.xpath("//table[@class='list view table-responsive']//tr//td[8]");

    public Activity9() {
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
    public void printTableNamesAndUserTest() {
        driver.findElement(sales).click();
        driver.findElement(lead).click();
        // Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableElements));

        List<WebElement> listElementsOne = driver.findElements(tableColoumName);
        List<WebElement> listElementsTwo = driver.findElements(tableColoumUser);
        for(int i=1;i<=10;i++) {
            String name =  listElementsOne.get(i).getText();
            String user =  listElementsTwo.get(i-1).getText();
            assertTrue(name != "" && name !=null , "Name "+i);
            assertTrue(user != "" && user !=null , "User "+i);
            System.out.println(name);
            System.out.println(user);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Finished Test On Firefox Browser");
    }
}
