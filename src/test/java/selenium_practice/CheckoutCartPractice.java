package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutCartPractice {
    WebDriver driver;
    String[] itemArr = {"Cucumber","Brocolli", "Beetroot"};
    int j = 0;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://rahulshettyacademy.com/seleniumPractise/");
    }

    @Test
    public void checkoutTest() {
        List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
        List veggies = Arrays.asList(itemArr);
        for (int i = 0; i < items.size(); i++) {
            String[] item = items.get(i).getText().split("-");
            String formattedName = item[0].trim();
            if (veggies.contains(formattedName)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;
                if (j == itemArr.length) {
                    break;
                }
            }
        }
        WebElement cart = driver.findElement(By.cssSelector("img[alt='Cart']"));
        cart.click();
        WebElement proceedCheckout = driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"));
        proceedCheckout.click();
        WebDriverWait w = new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        WebElement promoCode = driver.findElement(By.cssSelector("input.promoCode"));
        promoCode.sendKeys("rahulshettyacademy");
        WebElement apply = driver.findElement(By.cssSelector("button.promoBtn"));
        apply.click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        String promoText = driver.findElement(By.cssSelector("span.promoInfo")).getText();
        String expectedText = "Code applied ..!";
        Assert.assertEquals(promoText,expectedText);
        WebElement placeOrder = driver.findElement(By.xpath("//span[@class='discountAmt']//following-sibling::button"));
        placeOrder.click();

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByValue("Turkey");
        WebElement agreeTerms = driver.findElement(By.cssSelector("input.chkAgree"));
        agreeTerms.click();
        WebElement proceedButton = driver.findElement(By.xpath("//button[.='Proceed']"));
        proceedButton.click();
    }
}
