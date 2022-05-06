package liveProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/crm/");
        String actualTitle = "SuiteCRM";

        String Title = driver.getTitle();

        System.out.println("The Title of the Page is "+Title);

        if(actualTitle.equals(Title)){
            driver.close();
        }

    }
}
