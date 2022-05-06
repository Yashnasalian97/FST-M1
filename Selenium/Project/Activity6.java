package liveProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alchemy.hguy.co/crm/");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.className("btn-lg")).click();

        WebElement activity = driver.findElement(By.xpath("//nav/div/div[2]/ul/li[5]"));
        String value = activity.getText();
        activity.click();

        if(value.contains("ACTIVITIES")){
            System.out.println("Activities menu item exists and is clickable.");
            driver.close();
        }

    }
}