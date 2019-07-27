package com.cybertek.tests.Day6;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import com.cybertek.utilities.BrowserFactory;

public class WarmUp2 {

    public static void main(String[] args) throws Exception {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://www.wikipidea.org");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("selenium webdriver");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='pure-button pure-button-primary-progressive']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();
        Thread.sleep(5000);



        String currentUrl =  driver.getCurrentUrl();
        Character lastChar = currentUrl.charAt(currentUrl.length()-1);
        Character expectedValue = 'x';

        if (lastChar == expectedValue){
            System.out.println("Test passed successfully!");
        }else{
            System.out.println("Test failed!");
            System.out.println("Actual result: " + currentUrl);
            System.out.println("Expected result: " + expectedValue);
        }

        driver.quit();

    }


}