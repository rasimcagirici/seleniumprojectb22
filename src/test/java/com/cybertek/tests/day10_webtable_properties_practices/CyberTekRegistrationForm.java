package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CyberTekRegistrationForm {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("cybertekRegistrationUrl"));
    }

    @Test
    public void registrationTest() {

        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("username");

        WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phoneNumber = driver.findElement(By.cssSelector("input[name='phone']"));
        phoneNumber.sendKeys("814-256-5173");

        WebElement genderButton = driver.findElement(By.cssSelector("input[value='male']"));
        genderButton.click();

        WebElement dateOfBirth = driver.findElement(By.cssSelector("input[name='birthday']"));
        dateOfBirth.sendKeys("05/22/1990");

        WebElement departmentDropdown = driver.findElement(By.cssSelector("select[name='department']"));
        Select selectDepartment = new Select(departmentDropdown);
        selectDepartment.selectByVisibleText("Accounting Office");

        WebElement jobTitleDropdrown = driver.findElement(By.cssSelector("select[name='job_title']"));
        Select selectJobTitle = new Select(jobTitleDropdrown);
        selectJobTitle.selectByVisibleText("SDET");

        WebElement javaCheckbox = driver.findElement(By.cssSelector("input#inlineCheckbox2"));
        javaCheckbox.click();

        WebElement signUp = driver.findElement(By.cssSelector("button#wooden_spoon"));
        signUp.click();

        WebElement completedRegistration = driver.findElement(By.xpath("//p"));
        String actualResult = completedRegistration.getText();
        String expectedResult = "You've successfully completed registration!";

        Assert.assertEquals(actualResult,expectedResult,"Actual result doesn't equal expected result");





    }
}
