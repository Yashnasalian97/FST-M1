package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity7 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alchemy.hguy.co/crm/");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.className("btn-lg")).click();

        WebElement sales = driver.findElement(By.xpath("//nav/div/div[2]/ul/li[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(sales).build().perform();
        driver.findElement(By.xpath("//nav/div/div[2]/ul/li[2]/span/ul/li[5]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[10]")));
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement phone = driver.findElement(By.xpath("//div[@id='bootstrap-container']/div//div[7]/div[2]//span"));
        System.out.println("The phone number present in additional details is "+phone.getText());

        driver.close();

    }
}