package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment1 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void test1() {
        WebElement firstCheckbox = driver.findElement(By.id("checkBoxOption1"));
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected());
        firstCheckbox.click();
        Assert.assertTrue(!firstCheckbox.isSelected());
        List<WebElement> listOfCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(listOfCheckboxes.size());
    }
}
