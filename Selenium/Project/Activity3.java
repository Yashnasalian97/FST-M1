package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/crm/");

        WebElement footer = driver.findElement(By.id("admin_options"));
        String text = footer.getText();

        System.out.println("The first copyright text in the footer is "+text);

        driver.close();
    }
}