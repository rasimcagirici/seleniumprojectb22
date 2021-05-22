package com.cybertek.tests.day3_review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_FacebookIncorrectLoginTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("rasimcagirici@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("NurRas0818" + Keys.ENTER);
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Log into Facebook";
        if (actualTitle.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Incorrect login title verification PASSED!");
        } else {
            System.out.println("Incorrect login title verification FAILED!");
        }
    }
}
