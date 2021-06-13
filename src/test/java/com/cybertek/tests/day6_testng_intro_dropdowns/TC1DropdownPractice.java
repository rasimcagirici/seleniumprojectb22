package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC1DropdownPractice {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1_simple_dropdown_test() {
        System.out.println("Running test 1...");

        driver.get("http://practice.cybertekschool.com/dropdown");

        String expectedValue = "Please select an option";
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String actualValue = simpleDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualValue,expectedValue);

        String expectedStateSelection = "Select a State";
        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualStateSelection = stateSelection.getFirstSelectedOption().getText();
        Assert.assertEquals(actualStateSelection,expectedStateSelection);

        driver.close();
    }

    @Test
    public void test2()  {
        System.out.println("Running test 2...");

        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateSelection.selectByVisibleText("Illinois");
        stateSelection.selectByValue("VA");
        stateSelection.selectByIndex(5);
        String expectedResult = "California";
        String actualResult = stateSelection.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult,expectedResult,"verifying results");

        driver.close();
    }

    @Test
    public void test3() {
        System.out.println("Running test 3...");

        Select selectYear  = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectYear.selectByVisibleText("1922");

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        selectMonth.selectByValue("11");

        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        selectDay.selectByIndex(0);

        String expectedResult = "December 1st, 1922";
        String actualResult = selectMonth.getFirstSelectedOption().getText() + " " + selectDay.getFirstSelectedOption().getText() + "st, " + selectYear.getFirstSelectedOption().getText();
        Assert.assertEquals(actualResult,expectedResult,"Verifying date selected");

        driver.close();
    }

    @Test
    public void test4() {
        System.out.println("Running test 4...");

        Select multiSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        multiSelectDropdown.selectByIndex(0);
        multiSelectDropdown.selectByValue("js");
        multiSelectDropdown.selectByVisibleText("C#");
        multiSelectDropdown.selectByIndex(3);
        multiSelectDropdown.selectByValue("ruby");
        multiSelectDropdown.selectByVisibleText("C");

        List<WebElement> selectOption = multiSelectDropdown.getAllSelectedOptions();
        for (WebElement each : selectOption) {
            System.out.println(each.getText());
        }

        multiSelectDropdown.deselectAll();

        driver.close();
    }

    @Test
    public void test5() {
        System.out.println("Running test 5...");

        WebElement dropdownLink = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropdownLink.click();
        WebElement dropdownList = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']/following-sibling::div/a[4]"));
        dropdownList.click();

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        driver.close();
    }
}
