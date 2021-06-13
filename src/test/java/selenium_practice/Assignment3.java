package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
    }

    @Test
    public void explicitWaitTest() {
        WebDriverWait w = new WebDriverWait(driver,5);
        WebElement link = driver.findElement(By.xpath("//a[.='Click to load get data via Ajax!']"));
        link.click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#results")));
        String actualText = driver.findElement(By.cssSelector("div#results")).getText();
        String expectedText = "Process completed! This response has been loaded via the Ajax request directly from the web server, without reoading this page.";
        Assert.assertEquals(actualText,expectedText);
    }
}
