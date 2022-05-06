package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alchemy.hguy.co/crm/");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.className("btn-lg")).click();

        String home = "https://alchemy.hguy.co/crm/index.php?module=Home&action=index";
        String currentURL = driver.getCurrentUrl();

        if(home.equals(currentURL)){
            driver.close();
        }


    }
}
