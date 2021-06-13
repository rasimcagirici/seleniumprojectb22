package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assignment2 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://cleartrip.com");
    }

    @Test
    public void test1() {

        WebElement adult = driver.findElement(By.id("Adults"));
        Select selectAdults = new Select(adult);
        selectAdults.selectByValue("2");
        WebElement children = driver.findElement(By.id("Childrens"));
        Select selectChildrens = new Select(children);
        selectChildrens.selectByIndex(1);
        WebElement calendar = driver.findElement(By.cssSelector(".icon.ir.datePicker"));
        calendar.click();
        WebElement currentDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"));
        currentDate.click();
        WebElement moreOptions = driver.findElement(By.id("MoreOptionsLink"));
        moreOptions.click();
        WebElement classOfTravel = driver.findElement(By.id("Class"));
        Select classOfTravelOption = new Select(classOfTravel);
        classOfTravelOption.selectByVisibleText("Business");
        WebElement preferredAirline = driver.findElement(By.id("AirlineAutocomplete"));
        preferredAirline.sendKeys("indigo");
        WebElement submitButton = driver.findElement(By.id("SearchBtn"));
        submitButton.click();
        String expectedText = "Sorry, but we can't continue until you fix everything that's marked in RED";
        String actualText = driver.findElement(By.id("homeErrorMessage")).getText();
        Assert.assertEquals(actualText,expectedText);






    }
}
