package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTasks {

    @Test
    public void actionTask() {
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//img)[1]"))).build().perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']")).isDisplayed());

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//img)[2]"))).build().perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']")).isDisplayed());

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//img)[3]"))).build().perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']")).isDisplayed());

    }

    @Test
    public void scrollingTest() {
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[@href='https://cybertekschool.com/']"))).perform();

        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void doubleClickTest() {
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.cssSelector("iframe#iframeResult")));
        WebElement text = Driver.getDriver().findElement(By.cssSelector("p#demo"));
        actions.moveToElement(text).doubleClick().perform();

        WebElement colorText = Driver.getDriver().findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(colorText.isDisplayed());
    }

    @Test
    public void dragAndDropTest() {
        /*
        TC #16: Hover Test1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        2.Drag and drop the small circle to bigger circle.
        3.Assert: -Text in big circle changedto: “You did great!”
         */
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

    }

}
