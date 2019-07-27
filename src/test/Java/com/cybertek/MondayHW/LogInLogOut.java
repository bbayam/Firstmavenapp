package com.cybertek.MondayHW;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.cybertek.utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class LogInLogOut {

    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) throws Exception {
        Test1();
    }


    public static void Test1() throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);

        String ExpectedMessage= "You entered invalid credentials";
        String ActualMessage = driver.findElement(By.className("subheader")).getText();
        if(ExpectedMessage.equals(ActualMessage)){
            System.out.println("Login Successful");
        }else {
            System.out.println("login Failed");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
        Thread.sleep(2000);


        driver.close();






    }
}

