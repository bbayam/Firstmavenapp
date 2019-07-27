package com.cybertek.tests.Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;

import java.util.List;

public class MultipleButtonsPracticeWithXPath {
    WebDriver driver;

    //only button from 1-5
    String allbuttonsLocator = "//button[starts-with(text(),'Button')]";

    String button1Locator = "//button[.='Button 1']";
    String button2Locator = "//*[contains(@name,'button2')]";
    String button3Locator = "//button[starts-with(@id,'button_')]";
    String resultLocator = "//p[@id='result']";
    String button4Locator ="//button[contains(text(),'Button 4')]";
    String button5Locator = "//button[5]";
    String button6Locator = "//*[@id='disappearing_button']";
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }
    @Test
    public void verifyButton3(){
        String expectedMessage = "Clicked on button three!";
        driver.findElement(By.xpath(button3Locator)).click();
        SeleniumUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);


    }
    @Test
    public void verifyButton4() {
        String expectedMessage = "Clicked on button four!";
        driver.findElement(By.xpath(button4Locator)).click();
        SeleniumUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }
    @Test
    public void verifyButton6() {
        String expectedMessage = "Now it's gone!";
        driver.findElement(By.xpath(button6Locator)).click();
        SeleniumUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        //Assert.assertTrue(driver.findElement(By.xpath(button6Locator)).isDisplayed());
        Assert.assertTrue(driver.findElements(By.xpath(button6Locator)).size()==0);
    }

    @Test
    public void clickOnEveryButton(){
        List<WebElement> buttons = driver.findElements(By.xpath(allbuttonsLocator));
        for (WebElement button : buttons){
            button.click();
            SeleniumUtils.waitPlease(1);
        }

    }


        @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
