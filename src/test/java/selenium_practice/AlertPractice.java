package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void alertPractice() {
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Rasim");
        WebElement alertButton = driver.findElement(By.id("alertbtn"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "Hello Rasim, share this practice page and share your knowledge";
        Assert.assertEquals(alert.getText(),expectedAlertText);
        alert.accept();
        String expectedConfirmText = "Hello Rasim, Are you sure you want to confirm?";
        name.sendKeys("Rasim");
        WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
        confirmButton.click();
        Alert confirmAlert = driver.switchTo().alert();
        Assert.assertEquals(confirmAlert.getText(),expectedConfirmText);
        alert.dismiss();
    }
}
