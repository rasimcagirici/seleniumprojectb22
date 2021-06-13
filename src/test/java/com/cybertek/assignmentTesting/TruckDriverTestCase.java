package com.cybertek.assignmentTesting;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TruckDriverTestCase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user33");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
    }

    @Test
    public void test1() throws InterruptedException {
        Actions a = new Actions(driver);
        Thread.sleep(2000);
        a.moveToElement(driver.findElement(By.xpath("//span[@class='title title-level-1']"))).build().perform();
        a.moveToElement(driver.findElement(By.xpath("//span[@class='title title-level-2']"))).click().build().perform();
        driver.findElement(By.xpath("//td[.='Cybertek123']")).click();
        WebElement text = driver.findElement(By.xpath("//span[.='General Information']"));
        Assert.assertTrue(text.isDisplayed());
    }

}
