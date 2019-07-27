package com.cybertek.tests.Day13_actions_jsexecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cybertek.utilities.SeleniumUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsClassTests {
    WebDriver driver;
    //simple hover example with images
    String user1TextLocator = "//a[@href='/users/1']/preceding-sibling::h5";
    String user1ImageLocator = "(//img)[1]";
    //hover over chain of actions
    String enabledOptionLocator = "ui-id-3";
    String downloadsOptionLocator = "ui-id-4";
    String pdfOptionLocator = "ui-id-5";
    //drag and drop
    String moonLocator = "draggable";
    String EarthLocator = "droptarget";





    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void hoverTest1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        //we are creating object of Actions class
        //we have to provide object of webDriver
        Actions action = new Actions(driver);

        //hover on element
        action.moveToElement(driver.findElement(By.xpath(user1ImageLocator))).perform();
        String expectedResult = "name: user1";
        String actualResult = driver.findElement(By.xpath(user1TextLocator)).getText();

        //verify that after hover event text is visible
        Assert.assertTrue(driver.findElement(By.xpath(user1TextLocator)).isDisplayed());
        Assert.assertEquals(actualResult,expectedResult);
        SeleniumUtils.waitPlease(3);
    }

    @Test
    public void hoverTest2() {
        driver.get("http://practice.cybertekschool.com/hovers");
        //we are creating object of Actions class
        //we have to provide object of webDriver
        Actions action = new Actions(driver);
        List<WebElement> images = driver.findElements(By.tagName("img"));
      for (WebElement image: images){
          //ONLY DEMO
          SeleniumUtils.waitPlease(1);
          action.moveToElement(image).perform();

      }


    }
    @Test
       public void hoverTest3(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        Actions action = new Actions(driver);
        WebElement enabledElement = driver.findElement(By.id(enabledOptionLocator));
        WebElement downloadsElement = driver.findElement(By.id(downloadsOptionLocator));
        WebElement pdfElement = driver.findElement(By.id(pdfOptionLocator));
        action.moveToElement(enabledElement).pause(1000).moveToElement(downloadsElement).pause(1000).moveToElement(pdfElement).build().perform();
        SeleniumUtils.waitPlease(2);   //JUST FOR DEMO

       }

       @Test
       public void dragAndDropTest1(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions action = new Actions(driver);
        WebElement moon = driver.findElement(By.id(moonLocator));   //source
        WebElement earth = driver.findElement(By.id(EarthLocator));  //target
        action.dragAndDrop(moon, earth).perform();
        //once we complerte drag and drop operation, we expect to see this message
        String expectedMessage = "You did great!";
        String actualMessage = earth.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        SeleniumUtils.waitPlease(3);
          //  var name = "user";

       }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}