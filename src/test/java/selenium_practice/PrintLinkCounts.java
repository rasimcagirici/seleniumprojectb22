package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PrintLinkCounts {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qaclickacademy.com/practice.php");
    }

    @Test
    public void linkTest() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> sectionLinks = footerdriver.findElements(By.tagName("a"));
        System.out.println(sectionLinks.size());
        WebElement columnDriver = footerdriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
        List<WebElement> columnLinks = columnDriver.findElements(By.tagName("a"));
        System.out.println(columnLinks.size());
        for (int i = 1; i < columnLinks.size(); i++) {
            String clickOnLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
            columnLinks.get(i).sendKeys(clickOnLink);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
