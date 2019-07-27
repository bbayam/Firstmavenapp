package com.cybertek.tests.Day13_actions_jsexecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cybertek.utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void jsExecutorTest1(){
        driver.get("http://practice.cybertekschool.com/");

        //we want to run some javascript code
        //for this, we have to use JavascriptExecutor interface
        //since it is an interface, we cannot create an object
        //we just have to cast WebDriver

      JavascriptExecutor js = (JavascriptExecutor)driver;
        //and then to execute script itself
        //we call executeScript() method
        //executeScript returns an object

        String title = (String) js.executeScript("return document.title");
        //or you can execute some script without any return

        js.executeScript("alert('HELLO SPARTANS!!!!!')");
        SeleniumUtils.waitPlease(3);

        //Alert interface handles alerts
        //what is alert?
        //it looks like pop up window
        Alert alert = driver.switchTo().alert();

        //we can use accept() method to select OK in the pop up
        alert.accept();

        SeleniumUtils.waitPlease(3);
        System.out.println(title);
    }
    @Test
    public void scrollTest1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for (int i=0; i<11; i++) {
            js.executeScript("window.scroll(0,250)");
            SeleniumUtils.waitPlease(1);
        }

    }

    //TEST CASE
    //STEP ! . go to ("http://practice.cybertekschool.com/");


    @Test
    public void scrollTest2(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement footerLink = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        SeleniumUtils.waitPlease(2);
        //scroll until footerLink is not visible
        //ones you see footerLink , script will stop scrollingh
        js.executeScript("arguments[0].scrollIntoView(true)", footerLink);
        //to click with jsexecutor
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].click()", footerLink);
        SeleniumUtils.waitPlease(2);
    }



    @AfterMethod
    public void teardown() {
     driver.quit();
    }
}