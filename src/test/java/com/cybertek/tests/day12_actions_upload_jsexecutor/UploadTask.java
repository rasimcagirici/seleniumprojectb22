package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTask {

    /*
    TC #14: UploadTest1.Go tohttp://practice.cybertekschool.com/upload
    2.Find some small file from your computer, and get the path of it.
    3.Upload the file.
    4.Assert: -Fileuploaded text is displayed on the page
     */

    @Test
    public void uploadTask() {
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        String path = "/Users/rasimcagirici/Downloads/wallpapers-zelda.zip";
        WebElement chooseFileButton = Driver.getDriver().findElement(By.cssSelector("input#file-upload"));
        chooseFileButton.sendKeys(path);
        WebElement uploadButton = Driver.getDriver().findElement(By.cssSelector("input#file-submit"));
        uploadButton.click();
        WebElement actualText = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertTrue(actualText.isDisplayed());


    }
}
