package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(" http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void informationAlertTest() {
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualText = resultText.getText();
        String expectedText = "You successfuly clicked an alert";
        Assert.assertTrue(resultText.isDisplayed(),"Text is not displayed");
        Assert.assertEquals(actualText,expectedText,"Actual text does not equal expected text");
        driver.close();
    }

    @Test
    public void confirmationAlertTest() {
        WebElement jsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualText = resultText.getText();
        String expectedText = "You clicked: Ok";
        Assert.assertTrue(resultText.isDisplayed(),"Text is not displayed");
        Assert.assertEquals(actualText,expectedText);
        driver.close();
    }

    @Test
    public void jsPromptTest() {
        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(),"Text is not displayed");
        String actualText = resultText.getText();
        String expectedText = "You entered: hello";
        Assert.assertEquals(actualText,expectedText,"Actual text failed");
        driver.close();
    }
}
