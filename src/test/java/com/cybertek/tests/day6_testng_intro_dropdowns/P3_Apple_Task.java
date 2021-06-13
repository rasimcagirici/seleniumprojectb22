package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P3_Apple_Task {
    public static void main(String[] args) {
        //TC #03: FINDELEMENTS_APPLE
        //1. Open Chrome browser
        //2. Go to https://www.apple.com
        //3. Click to all of the headers one by one
        //a. Mac, iPad, iPhone, Watch, TV, Music, Support
        //4. Print out the titles of the each page
        //5. Print out total number of links in each page
        //6. While in each page:
        //a. Print out how many link is missing text TOTAL
        //b. Print out how many link has text TOTAL

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

        for (int i = 1; i < headerLinks.size()-1; i++) {
            //System.out.println(headerLinks.get(i).getText());
            headerLinks.get(i).click();
            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
            System.out.println("Current title page " + driver.getTitle());
            List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
            System.out.println("Number of links in current page: " + allLinks.size());
            int linksWithNoText = 0;
            int linksWithText = 0;
            for (WebElement each : allLinks) {
                if (each.getText().isEmpty()) {
                    linksWithNoText++;
                } else {
                    linksWithText++;
                }
            }
            System.out.println("Number of links in current page with no text " + linksWithNoText);
            System.out.println("Number of links in current page with text " + linksWithText);
        }
    }
}
