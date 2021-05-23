package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesForce {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.cssSelector("input#username")).sendKeys("hello");
        driver.findElement(By.cssSelector("input#password")).sendKeys("world");
        driver.findElement(By.cssSelector("input#Login")).click();
    }
}
