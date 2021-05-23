package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookPath {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.facebook.com");
        //driver.findElement(By.xpath("//input[@id='email']")).sendKeys("myown xpath");
        //driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("HELLO MAN");
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        //driver.findElement(By.cssSelector("input[id='email']")).sendKeys("myown cssSelector");
        driver.findElement(By.cssSelector("input#email")).sendKeys("myown cssSelector");
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("HELLO MAN");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //tagName[contains(@attribute,'value')] - can be use for attributes that can change. - xpath way
        //tagName[attribute*='value'] - for css regular expression
    }
}
