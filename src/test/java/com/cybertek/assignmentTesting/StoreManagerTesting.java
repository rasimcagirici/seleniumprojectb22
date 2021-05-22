package com.cybertek.assignmentTesting;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoreManagerTesting {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys("salesmanager");
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.xpath("//button[@id='_submit']"));
        login.click();
        String expectedResult = "Invalid user name or password.";
        String actualResult = driver.findElement(By.xpath("//fieldset/div/div")).getText();
        if (actualResult.equals(expectedResult)) {
            System.out.println("verification PASSED!!");
        } else {
            System.out.println("verification FAILED!!");
        }
    }
}
