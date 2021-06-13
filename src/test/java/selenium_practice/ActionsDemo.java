package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsDemo {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void actionTest1() {
        WebElement accountTab = driver.findElement(By.cssSelector("a#nav-link-accountList"));
        Actions a = new Actions(driver);
        a.moveToElement(accountTab).contextClick().build().perform();
    }

    @Test
    public void actionTest2() {
        WebElement searchBar = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        Actions a = new Actions(driver);
        a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
    }
}
