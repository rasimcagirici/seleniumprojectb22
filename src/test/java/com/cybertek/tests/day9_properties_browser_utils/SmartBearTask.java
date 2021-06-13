package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTask {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void smartBearLinkVerification() {

        WebElement usernameTextBox = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        usernameTextBox.sendKeys("Tester");

        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
        passwordTextBox.sendKeys("test");

        WebElement loginButton = driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
        loginButton.click();

        List<WebElement> linksOnLanding = driver.findElements(By.xpath("//body//a"));

        System.out.println(linksOnLanding.size());

        for (WebElement each : linksOnLanding) {
            System.out.println(each.getText());
        }

    }

    @Test
    public void smartBearSoftwareOrderPlacing() {
        SmartBearUtils.login(driver);

        WebElement orderLink = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLink.click();

        WebElement productDropdown = driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select selectDropdown = new Select(productDropdown);
        selectDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityText = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityText.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.cssSelector("input.btn_dark"));
        calculateButton.click();

        Faker faker = new Faker();

        WebElement nameText = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_txtName"));
        nameText.sendKeys(faker.name().fullName());

        WebElement addressText = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox2"));
        addressText.sendKeys(faker.address().streetAddress());

        WebElement cityText = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox3"));
        cityText.sendKeys(faker.address().city());

        WebElement stateText = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox4"));
        stateText.sendKeys(faker.address().state());

        WebElement zipCode = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys("08432");

        WebElement cardType = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_cardList_0"));
        cardType.click();

        WebElement cardNumber = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("6524223028081703");

        WebElement cardNumberSecurityCard = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox1"));
        cardNumberSecurityCard.sendKeys("11/22");

        WebElement processButton = driver.findElement(By.cssSelector("a#ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        WebElement successfulOrderText = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        String actualText = successfulOrderText.getText();
        String expectedText = "New order has been successfully added.";

        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void verifyOrder() {
        SmartBearUtils.login(driver);

        WebElement susanOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Susan McLaren']/following-sibling::td[3]"));
        String actualOrderDateText = susanOrderDate.getText();
        String expectedOrderDateText = "01/05/2010";
        Assert.assertEquals(actualOrderDateText,expectedOrderDateText);

        //TC#3: Smartbear software order verification
        // 1.Open browser and login to Smartbear software
        // 2.Click on View all orders
        // 3.Verify Susan McLaren has order on date “01/05/2010”
    }
}
