package com.cybertek.tests.day5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeID {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{
        //test1();
        test2();

    }
    //negative test, we will use wrong id to locate element
    public static void test1() throws InterruptedException {
        driver.manage().window().maximize();
        //selenium will wait 10 seconds for elemnt
        //if , within 10 seconds, element will not show up
        //you will get NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.id("woodenspoon")).click();
        Thread.sleep(3000); //suspends java execution on certain time
        driver.quit();
    }

    public static void test2()throws Exception{
        driver.manage().window().maximize();
        //this is you must to use, otherwise you will be in trouble
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        String expectedMessage= "Welcome to the Secure Area. When yo are done click logout below.";
        String actualMessage= driver.findElement(By.className("subheader")).getText();
        SeleniumUtils.verifyEquals(expectedMessage,actualMessage);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(3000);
        driver.quit();


    }
}

