package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorPractice {

    @Test
    public void scrollUsingJSExecutorTest1() {
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,750)");
        }
    }

    @Test
    public void scrollUsingJSExecutorTest2() {
        Driver.getDriver().get("http://practice.cybertekschool.com/large");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));


        js.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLink);

        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);

    }
}
