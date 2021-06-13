package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Assignment4 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    public void windowTest() {
        WebElement windowLink = driver.findElement(By.xpath("//a[.='Multiple Windows']"));
        windowLink.click();
        WebElement newWindow = driver.findElement(By.cssSelector("a[href='/windows/new']"));
        newWindow.click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String>it = windowHandles.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        WebElement childWindowText = driver.findElement(By.xpath("//div[@class='example']/h3"));
        String actualChildResult  = childWindowText.getText();
        String expectedChildResult = "New Window";
        Assert.assertEquals(actualChildResult,expectedChildResult);
        driver.switchTo().window(parentId);
        WebElement parentWindowText = driver.findElement(By.xpath("//div[@class='example']/h3"));
        String actualParentResult = parentWindowText.getText();
        String expectedParentResult = "Opening a new window";
        Assert.assertEquals(actualParentResult,expectedParentResult);

    }
}
