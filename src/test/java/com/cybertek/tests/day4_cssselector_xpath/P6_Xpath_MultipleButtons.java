package com.cybertek.tests.day4_cssselector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6_Xpath_MultipleButtons {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //WebElement buttonOne = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        buttonOne.click();
        WebElement buttonOneText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualButtonOneText = buttonOneText.getText();
        String expectedButtonOneText = "Clicked on button one!";
        if (actualButtonOneText.equals(expectedButtonOneText)) {
            System.out.println("Text verification PASSED!");
        } else {
            System.out.println("Text verification FAILED!");
        }
        WebElement buttonTwo = driver.findElement(By.xpath("//button[@onclick='button2()']"));
        buttonTwo.click();
        WebElement buttonTwoText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualButtonTwoText = buttonTwoText.getText();
        String expectedButtonTwoText = "Clicked on button two!";
        if (actualButtonTwoText.equals(expectedButtonTwoText)) {
            System.out.println("Text verification PASSED!");
        } else {
            System.out.println("Text verification FAILED!");
        }
        driver.close();
    }
}
