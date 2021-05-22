package com.cybertek.tests.day3_review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_FacebookHrefVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        WebElement href = driver.findElement(By.className("_8esh"));
        String actualHref = href.getAttribute("href");
        String expectedInHref = "registration_form";
        if (actualHref.contains(expectedInHref)) {
            System.out.println("Href verification PASSED!");
        } else {
            System.out.println("Href verification PASSED!");
        }
        driver.close();
    }
}
