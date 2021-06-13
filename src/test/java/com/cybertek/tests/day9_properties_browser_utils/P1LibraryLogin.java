package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.LibraryUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1LibraryLogin {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://library2.cybertekschool.com/login.html");
    }


//     6. Print out count of all the links on landing page
//     7. Print out each link text on this page

    @Test
    public void loginLinkCountTest() {
        LibraryUtils.loginToLibrary(driver);
        BrowserUtils.sleep(2);
        List<WebElement> linksOnLandingPage = driver.findElements(By.xpath("//body//a"));
        System.out.println(linksOnLandingPage.size());
        for (WebElement each : linksOnLandingPage) {
            System.out.println(each.getText());
        }
    }
}
