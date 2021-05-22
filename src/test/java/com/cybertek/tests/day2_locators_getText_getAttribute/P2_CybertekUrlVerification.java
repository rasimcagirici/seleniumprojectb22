package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekUrlVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com");

        String expectedInUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedInUrl)) {
            System.out.println("Url verification PASSED!");
        } else {
            System.out.println("Url verification FAILED!");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();
    }
}
