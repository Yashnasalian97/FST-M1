package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/crm/");
        String actualTitle = "SuiteCRM";
        WebElement url =driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
        System.out.println("URL of header image: "+ url.getAttribute("src"));




            driver.close();
        }

    }

