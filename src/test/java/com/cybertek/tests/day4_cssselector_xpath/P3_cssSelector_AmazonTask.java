package com.cybertek.tests.day4_cssselector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_cssSelector_AmazonTask {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        WebElement searchBar = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBar.sendKeys("wooden spoon" + Keys.ENTER);

        String expectedTitle = "Amazon.com : wooden spoon";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();
    }
}
