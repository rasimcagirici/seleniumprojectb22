package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    public static void login(WebDriver driver) {

        WebElement usernameTextBox = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        usernameTextBox.sendKeys("Tester");

        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
        passwordTextBox.sendKeys("test");

        WebElement loginButton = driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
        loginButton.click();

    }
}
