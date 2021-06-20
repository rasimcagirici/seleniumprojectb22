package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalenderTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.path2usa.com/travel-companions");
    }

    @Test
    public void calenderTest() {

        WebElement departureCity = driver.findElement(By.cssSelector("input#travel_from"));
        departureCity.click();
        departureCity.sendKeys("jfk");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//div[@class='optionDivSelected']"))).click().build().perform();

        WebElement arrivalCity = driver.findElement(By.cssSelector("input#travel_to"));
        arrivalCity.click();
        arrivalCity.sendKeys("los");

        a.moveToElement(driver.findElement(By.xpath("//div[@class='optionDivSelected']"))).click().build().perform();

        WebElement travelDate = driver.findElement(By.id("travel_date"));
        travelDate.click();

        WebElement month = driver.findElement(By.className("datepicker-switch"));
        month.click();
        List<WebElement> months = driver.findElements(By.className("month"));
        for (int i = 0; i < months.size(); i++) {
            if (months.get(i).getText().equals("Jul")) {
                months.get(i).click();
                break;
            }
        }

        List<WebElement> dates = driver.findElements(By.className("day"));
        for (int i = 0; i < dates.size(); i++) {
            if (dates.get(i).getText().equals("14")) {
                dates.get(i).click();
                break;
            }
        }

        WebElement dateBetween = driver.findElement(By.id("datebetween"));
        Select selectDate = new Select(dateBetween);
        selectDate.selectByVisibleText("+ - 2 Weeks");

        WebElement airline = driver.findElement(By.id("travel_airline"));
        Select selectAirline = new Select(airline);
        selectAirline.selectByVisibleText("Turkish Airlines");

        WebElement language = driver.findElement(By.id("travel_language"));
        Select selectLanguage = new Select(language);
        selectLanguage.selectByVisibleText("English");

        WebElement button = driver.findElement(By.xpath("//button[.='SEARCH']"));
        button.click();
    }
}
