package com.cybertek.tests.Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;

public class AbsoluteXpathDemo {
    // we use only inside this class, thAT is why it is private
    WebDriver driver = BrowserFactory.getDriver("chrome");
    String fullNameLocator ="html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']";
    String emailLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']";
    String signUpButton = "html/body/div/div[2]/div/div/form/button";

    @BeforeMethod  //it runs before very @Test
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
    }
    @Test
    public void test1(){
        //find input box to enter name
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']")).sendKeys("Jon SNOW");

        //find input box to enter email
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']")).sendKeys("jonsnow@email.com");
        SeleniumUtils.waitPlease(2);

        //find a button to click sign up
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/button")).click();
        SeleniumUtils.waitPlease(2);

        //expected message
        String expectedmessage ="Thank you for signing up. CLick the button below to return to the home page.";

        //actual will be coming from the page
        String actualmessage = driver.findElement(By.xpath("html/body/div/div[2]/div/div/h3")).getText();

        //verify that expected and actual message is the same
        //if no, it will stop test and throw exception
        //you will see in the console log what's exactly didn't match
        Assert.assertEquals(actualmessage, expectedmessage);
    }
    @Test
    public void negativeEmailTest(){
        String expectedLink = driver.getCurrentUrl();
       driver.findElement(By.xpath(fullNameLocator)).sendKeys("Oberyn");
       driver.findElement(By.xpath(emailLocator)).sendKeys("email");
       driver.findElement(By.xpath(signUpButton)).click();
        SeleniumUtils.waitPlease(2);
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink,expectedLink);


    }


   @AfterMethod  //it will run after every @Test
    public void teardown(){
        driver.quit();
    }
}
