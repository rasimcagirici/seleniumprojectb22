package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPracticeTest {
    //static dropdown means options are fixed
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://rahulshettyacademy.com/dropdownsPractise/");
    }

    @Test
    public void staticDropdownTest() {
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"USD");
        dropdown.selectByVisibleText("AED");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"AED");
        dropdown.selectByValue("INR");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"INR");
        driver.close();
    }

    @Test
    public void passengerAmountSelectTest() {
        WebElement passengerAmount = driver.findElement(By.id("divpaxinfo"));
        passengerAmount.click();

        WebElement addAdultAmount = driver.findElement(By.id("hrefIncAdt"));
        for (int i = 0; i < 2; i++) {
            addAdultAmount.click();
        }

        WebElement childAmount = driver.findElement(By.id("hrefIncChd"));
        childAmount.click();

        WebElement clickDone = driver.findElement(By.id("btnclosepaxoption"));
        clickDone.click();

        WebElement passengerCount = driver.findElement(By.id("divpaxinfo"));
        String passengerCountText = passengerCount.getText();
        Assert.assertEquals(passengerCountText,"3 Adult, 1 Child");
    }

    @Test
    public void dynamicDropdownTest() {
        WebElement dynamicDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        dynamicDropdown.click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='IXJ']")).click();
    }

    @Test
    public void autoSuggestiveDropdownTest() {
        WebElement autoDropDown = driver.findElement(By.id("autosuggest"));
        autoDropDown.sendKeys("Tu");
        WebElement turkeySelect = driver.findElement(By.xpath("//a[.='Turkey']"));
        turkeySelect.click();
    }

    @Test
    public void checkBoxesTest() {
        WebElement friendsAndFamily = driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));
        friendsAndFamily.click();
        Assert.assertTrue(friendsAndFamily.isSelected());
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkboxes.size());
    }

    @Test
    public void calenderDateTest() {
        driver.get("https://www.spicejet.com/");
        WebElement calender = driver.findElement(By.cssSelector(".ui-datepicker-trigger"));
        calender.click();
        WebElement activeDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-active"));
        activeDate.click();
    }
}
