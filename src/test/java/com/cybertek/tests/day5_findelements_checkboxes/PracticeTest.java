package com.cybertek.tests.day5_findelements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void practice1() {
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        Assert.assertTrue(homeLink.isDisplayed());

        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        Assert.assertTrue(forgotPassword.isDisplayed());

        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
        Assert.assertTrue(emailText.isDisplayed());

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
        Assert.assertTrue(emailInputBox.isDisplayed());

        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
        Assert.assertTrue(retrievePasswordButton.isDisplayed());

        WebElement cybertekSchoolText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        Assert.assertTrue(cybertekSchoolText.isDisplayed());
    }

    @Test
    public void practice2() {
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addElement = driver.findElement(By.cssSelector("button[onClick='addElement()']"));
        addElement.click();

        WebElement deleteButton = driver.findElement(By.cssSelector("button.added-manually"));
        Assert.assertTrue(deleteButton.isDisplayed());

        try {
            deleteButton.click();
            Assert.assertTrue(!deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e) {

        }
    }

    @Test
    public void practice3() {
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addElement = driver.findElement(By.cssSelector("button[onClick='addElement()']"));

        for (int i = 0; i < 50; i++) {
            addElement.click();
        }

        WebElement deleteButton = driver.findElement(By.cssSelector("button.added-manually"));
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button.added-manually"));
        Assert.assertEquals(deleteButtons.size(),50);

        for (WebElement each : deleteButtons) {
            each.click();
        }

        try {
            Assert.assertFalse(deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e) {

        }
    }

    @Test
    public void practice4() {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement successText = driver.findElement(By.cssSelector("div#txtAge"));
        try {
            Assert.assertTrue(!successText.isDisplayed());
        } catch (StaleElementReferenceException e) {

        }

        WebElement singleCheckbox = driver.findElement(By.cssSelector("input#isAgeSelected"));
        singleCheckbox.click();
        Assert.assertTrue(successText.isDisplayed());
    }

    @Test
    public void practice5() {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAll = driver.findElement(By.cssSelector("input#check1"));
        String expectedText = "Check All";
        String actualText = checkAll.getAttribute("value");
        Assert.assertEquals(actualText,expectedText);

        checkAll.click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input.cb1-element"));
        for (WebElement each : checkboxes) {
            Assert.assertTrue(each.isSelected());
        }

        String expectedUncheckText = "Uncheck All";
        String actualUncheckText = checkAll.getAttribute("value");
        Assert.assertEquals(actualUncheckText,expectedUncheckText);
    }

    @Test
    public void practice6() {
        driver.get("https://www.merriam-webster.com/");

        List<WebElement> linkText = driver.findElements(By.xpath("//body//a"));
        int missingText = 0;
        int textNumber = 0;

        for (WebElement each : linkText) {
            System.out.println(each.getText());
            if (each.getText().isEmpty()) {
                missingText++;
            } else {
                textNumber++;
            }
        }

        System.out.println("missingText = " + missingText);
        System.out.println("textNumber = " + textNumber);
        System.out.println("total = " + (textNumber + missingText));
    }

    @Test
    public void practice7() {
        driver.get("https://www.apple.com");

        WebElement iPhoneTab = driver.findElement(By.cssSelector("a[href='/iphone/']"));
        iPhoneTab.click();

        List<WebElement> links = driver.findElements(By.xpath("//body//a"));
        int missingLinksText = 0;
        int presentLinksText = 0;

        for (WebElement each : links) {
            System.out.println(each.getText());
            if (each.getText().isEmpty()) {
                missingLinksText++;
            } else {
                presentLinksText++;
            }
        }

        System.out.println("missingLinksText = " + missingLinksText);
        System.out.println("presentLinksText = " + presentLinksText);
        System.out.println("total = " + (missingLinksText + presentLinksText));
    }

    @Test
    public void practice8() {
        driver.get("https://www.apple.com");

        List<WebElement> headerLinks = driver.findElements(By.cssSelector(""));

        // 3.Click to all of the headers one by one
            //a.Mac, iPad, iPhone, Watch, TV, Music, Support
        // 4.Print out the titles of the each page
        // 5.Print out total number of links in each page
        // 6.While in each page:
            // a.Print out how many link is missing textTOTAL
            // b.Print out how many link has textTOTAL
    }
}
