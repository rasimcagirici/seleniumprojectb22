package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Rediff {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.rediff.com/");
        //driver.findElement(By.xpath("//a[contains(@title,'Sign in')]")).click();
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
        driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("hello");
        driver.findElement(By.cssSelector("input#password")).sendKeys("no");
        driver.findElement(By.cssSelector("input[value*='Sign in']")).click();
    }
}
