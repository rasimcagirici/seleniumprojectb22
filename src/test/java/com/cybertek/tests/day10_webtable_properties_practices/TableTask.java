package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TableTask {

    WebDriver driver;
    String browser = ConfigurationReader.getProperty("browser");
    String url = ConfigurationReader.getProperty("dataTablesUrl");

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void tableTask1() {

        WebElement timLocate = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']"));
        String expectedName = "Tim";
        String actualName = timLocate.getText();
        Assert.assertEquals(actualName,expectedName);

        WebElement timDueAmount = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/following-sibling::td[2]"));
        String expectedAmount = "$50.00";
        String actualAmount = timDueAmount.getText();
        Assert.assertEquals(actualAmount,expectedAmount);

    }

    @Test
    public void verifyOrderMethod() {

        TableUtils.verifyOrder(driver,"Tim");

    }
}
