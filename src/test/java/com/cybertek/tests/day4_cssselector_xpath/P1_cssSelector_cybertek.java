package com.cybertek.tests.day4_cssselector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_cssSelector_cybertek {
    public static void main(String[] args) {
        /*
        TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/forgot_password
        3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button
        f. “Powered by Cybertek School” text
        4. Verify all WebElements are displayed.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));

        WebElement forgotPasswordHeader = driver.findElement(By.tagName("h2"));

        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));

        WebElement emailInputBox = driver.findElement(By.cssSelector("input[name='email']"));

        WebElement retrievePassword = driver.findElement(By.cssSelector("button#form_submit"));

        WebElement cybertekText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        WebElement cybertekLink = driver.findElement(By.cssSelector("a[target='_blank']"));
        cybertekLink.click();

        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());

        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());

        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());

        System.out.println("emailInputBox.isDisplayed() = " + emailInputBox.isDisplayed());

        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());

        System.out.println("cybertekText.isDisplayed() = " + cybertekText.isDisplayed());
    }
}
