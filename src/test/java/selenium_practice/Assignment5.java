package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assignment5 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    public void frameTest1() {
        WebElement nestedFrameLink = driver.findElement(By.cssSelector("a[href='/nested_frames']"));
        nestedFrameLink.click();
        WebElement firstFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(firstFrame);
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(middleFrame);
        String actualMiddleFrameText = driver.findElement(By.cssSelector("div#content")).getText();
        String expectedMiddleFrameText = "MIDDLE";
        Assert.assertEquals(actualMiddleFrameText,expectedMiddleFrameText);
    }
}
