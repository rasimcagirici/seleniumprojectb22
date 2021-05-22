package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //1- setup the browser driver
        WebDriverManager.chromedriver().setup();

        //2- create instance of selenium web driver
        //this line opens a browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //3- get the page
        driver.get("https://www.tesla.com");

        System.out.println("Current title: " + driver.getTitle());
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //Going back using navigations
        Thread.sleep(3000);
        driver.navigate().back();

        //Going forward using navigations
        Thread.sleep(3000);
        driver.navigate().forward();

        //Refreshing page using navigations
        Thread.sleep(3000);
        driver.navigate().refresh();

        //Going to another url using .to() method
        Thread.sleep(3000);
        driver.navigate().to("https://www.google.com");
        System.out.println("Current title: " + driver.getTitle());
        System.out.println("Current url: " + driver.getCurrentUrl());

        //this method will close the currently open browser
        //it will only close one browser or one tab
        driver.close();

        //drive.quit(); will close all open browsers and tabs within the same session
        //a driver session is created when we click run, and it ends when selenium code stops
        //or when we say driver.quit
    }
}
