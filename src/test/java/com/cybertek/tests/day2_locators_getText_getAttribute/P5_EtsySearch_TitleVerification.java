package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_EtsySearch_TitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Etsy title verification PASSED!");
        } else {
            System.out.println("Etsy title verification FAILED!");
        }
        driver.close();
    }
}
