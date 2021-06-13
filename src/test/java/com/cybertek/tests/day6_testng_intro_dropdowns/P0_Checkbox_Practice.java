package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class P0_Checkbox_Practice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='box1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='box2']"));
        if (!checkbox1.isSelected()) {
            System.out.println("Checkbox #1 is NOT selected by default. Verification PASSED!");
        } else {
            System.out.println("Checkbox #1 is selected by default. Verification FAILED!");
        }
        if (checkbox2.isSelected()) {
            System.out.println("Checkbox #2 is SELECTED by default. Verification PASSED!!");
        } else {
            System.out.println("Checkbox #2 is NOT selected by default. Verification FAILED!!");
        }
        checkbox1.click();
        checkbox2.click();
        if (checkbox1.isSelected()) {
            System.out.println("Checkbox #1 is SELECTED. Verification PASSED!!");
        } else {
            System.out.println("Checkbox #2 is not selected. Verification FAILED!!");
        }
        if (!checkbox2.isSelected()) {
            System.out.println("Checkbox #2 is NOT selected. Verification PASSED!!");
        } else {
            System.out.println("Checkbox #2 is SELECTED. Verification FAILED!!");
        }
        driver.close();
    }
}
