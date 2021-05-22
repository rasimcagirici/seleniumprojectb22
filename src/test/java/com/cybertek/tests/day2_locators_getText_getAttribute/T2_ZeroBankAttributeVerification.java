package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankAttributeVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement zeroBankLink = driver.findElement(By.className("brand"));
        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();
        if (actualLinkText.equals(expectedLinkText)) {
            System.out.println("Link text verification PASSED!");
        } else {
            System.out.println("Link text verification FAILED!");
        }
        String expectedInLink = "index.html";
        String actualLink = zeroBankLink.getAttribute("href");
        if (actualLink.contains(expectedInLink)) {
            System.out.println("HREF attribute value verification PASSED!");
        } else {
            System.out.println("HREF attribute value verification FAILED!");
        }
        driver.close();
    }
}
