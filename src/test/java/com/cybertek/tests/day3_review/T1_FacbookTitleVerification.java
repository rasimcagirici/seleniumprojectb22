package com.cybertek.tests.day3_review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_FacbookTitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Verification PASSED!");
        } else {
            System.out.println("Title Verification FAILED!");
        }
        driver.close();
    }
}
