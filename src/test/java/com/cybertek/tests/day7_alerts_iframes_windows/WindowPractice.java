package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPractice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void windowTest() {
        Assert.assertEquals(driver.getTitle(),"Practice");
        WebElement clickLink = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickLink.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            if(!each.equals(driver.getWindowHandle())) {
                driver.switchTo().window(each);
            }
        }
        Assert.assertEquals(driver.getTitle(),"New Window");
    }
}
