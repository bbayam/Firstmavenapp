package com.cybertek.tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cybertek.utilities.BrowserFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeClassName {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    //assignment: Get a list of examples  based on the class name list-group-item
    //then use for loop to get every element and print the text of this element.
    //check how many elements you will get, it must be 47.

    public static void main(String[] args) {
        Test1();
    }

    public static void Test1()  {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://practice.cybertekschool.com");
        List<WebElement> classNames = driver.findElements(By.className("list-group-item"));
        System.out.println(classNames.size());
        for(WebElement a:classNames){
            System.out.println(a.getText());
        }

        driver.close();
    }
}
