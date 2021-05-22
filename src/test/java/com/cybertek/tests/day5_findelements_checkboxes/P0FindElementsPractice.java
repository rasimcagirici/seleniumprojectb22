package com.cybertek.tests.day5_findelements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P0FindElementsPractice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/forgot_password");
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        for (WebElement each : listOfLinks) {
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }
        System.out.println("Amount of links = " + listOfLinks.size());
        driver.close();
    }
}
