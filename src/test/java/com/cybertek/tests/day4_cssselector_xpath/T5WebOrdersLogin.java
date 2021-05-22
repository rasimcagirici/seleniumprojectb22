package com.cybertek.tests.day4_cssselector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5WebOrdersLogin {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUsername.sendKeys("Tester");

        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test");

        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
        login.click();

        String actualHomePageTitle = driver.getTitle();
        String expectedHomePageTitle = "Web Orders";

        if (actualHomePageTitle.equals(expectedHomePageTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }
    }
}
