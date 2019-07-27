package com.cybertek.MondayHW;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.cybertek.utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class Vytrackk {

    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) throws Exception{
        Test1();
    }

    public static void Test1() throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user169");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);


        String ExpectedMessage = "Quick Launchpad";
        String ActualMessage = driver.findElement(By.className("oro-subtitle")).getText();

        if(ExpectedMessage.equals(ActualMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }


        driver.findElement(By.className("fa-caret-down")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[4]/a")).click();


    }
}

