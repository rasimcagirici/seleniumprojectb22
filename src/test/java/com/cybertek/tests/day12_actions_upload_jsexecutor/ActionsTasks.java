package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
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

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement draggable = Driver.getDriver().findElement(By.cssSelector("div#draggable"));
        WebElement droppable = Driver.getDriver().findElement(By.cssSelector("div#droptarget"));

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.dragAndDrop(draggable,droppable).perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[.='You did great!']")).isDisplayed());

    }

    @Test
    public void contextClick() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = Driver.getDriver().findElement(By.cssSelector("div#hot-spot"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(box).contextClick().perform();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }

}
