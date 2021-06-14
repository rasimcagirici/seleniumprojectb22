package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtils {

    public static void login(WebDriver driver) {

        WebElement usernameTextBox = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        usernameTextBox.sendKeys("Tester");

        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
        passwordTextBox.sendKeys("test");

        WebElement loginButton = driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
        loginButton.click();

    }

    public static void verifyOrder(WebDriver driver, String name) {

        List<WebElement> names = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));

        for (WebElement each : names) {
            if (each.getText().equalsIgnoreCase(name)) {
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.assertTrue(false,"Name provided not in list");
    }

    public static void printNamesAndCities(WebDriver driver) {
        List<WebElement> names = driver.findElements(By.xpath("//table[@class='SampleTable']//td[2]"));
        List<WebElement> cities = driver.findElements(By.xpath("//table[@class='SampleTable']//td[7]"));
        int count = 1;
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Name" + count + ": " + names.get(i).getText() + " , " + "City" + count + ": " + cities.get(i).getText());
            count++;
        }

    }
}
