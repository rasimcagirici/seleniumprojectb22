package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FrameTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://jqueryui.com/droppable/");
    }

    @Test
    public void frameTest1() {
        Actions a = new Actions(driver);
        WebElement frameOne = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(frameOne);
        WebElement dragTarget = driver.findElement(By.id("draggable"));
        WebElement dropTarget = driver.findElement(By.id("droppable"));
        a.moveToElement(dragTarget).dragAndDrop(dragTarget,dropTarget).build().perform();
        driver.switchTo().defaultContent();
        WebElement acceptLink = driver.findElement(By.xpath("//a[.='Accept']"));
        acceptLink.click();
    }
}
