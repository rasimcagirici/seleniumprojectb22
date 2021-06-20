package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTask extends TestBase {


    @Test
    public void tableTask1() {

        String url = ConfigurationReader.getProperty("dataTablesUrl");
        driver.get(url);

        WebElement timLocate = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']"));
        String expectedName = "Tim";
        String actualName = timLocate.getText();
        Assert.assertEquals(actualName,expectedName);

        WebElement timDueAmount = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/following-sibling::td[2]"));
        String expectedAmount = "$50.00";
        String actualAmount = timDueAmount.getText();
        Assert.assertEquals(actualAmount,expectedAmount);

    }

    @Test
    public void verifyOrderMethod() {
        String url = ConfigurationReader.getProperty("dataTablesUrl");
        driver.get(url);

        TableUtils.verifyOrder(driver,"Tim");

    }

    /*
    http://practice.cybertekschool.com/tables#edit

    PRACTICE #4: Method: verifyOrder
    •Create a method named verifyOrder in TableUtilsClass.
    •Method takes WebDriver object and String(name).
    •Method should verify if given name exists in orders.
    •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    •Create a new TestNG test to test if the method is working as expected.

    Practice #5: Method: printNamesAndEmails
    •Create a method named printNamesAndEmails in TableUtils class.
    •Method takes WebDriver object.
    •This method should simply print all the names and emails in the table
    •Create a new TestNG test to test if the method is working as expected.•
    Output should be like:
    •Name1: name , Email1: email•Name2: name , Email2: email

    Use of the methods:
    1.Create a new class
    2.Create new Tests
    3.Read URL usingConfigurationReader.getProperty
    4.Test if the utility methods are working as expected.
     */
}
