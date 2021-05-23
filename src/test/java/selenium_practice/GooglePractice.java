package selenium_practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePractice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[@class='gb_Xd gb_Ta gb_Jd']/div/div/div[2]/a")).click();
        WebElement searchBar = driver.findElement(By.xpath("//div[@class='a4bIc']/input"));
        searchBar.sendKeys("fenerbahce" + Keys.ENTER);
        driver.navigate().back();
        //*[id='tablist1-tab1']following-sibling::li[2] - travel to a sibling
        //*[id='tablist1-tab1']/parent::ul
        //xpath you can travel back. you can't do that on css selector
        /*
            //*[text()='selenium '] is an example where you can get object using text use this only if
            you attributes are dynamic and there isn't much.
         */
    }
}
