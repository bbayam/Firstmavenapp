package com.cybertek.tests.Day15;

import com.cybertek.pages.Vytrack.CalendarEventsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import com.cybertek.utilities.VYTrackUtils;

import java.util.Arrays;
import java.util.List;

public class CalenderEventsTest extends TestBase {

    //BeforeMethod is coming from TestBAse
 CalendarEventsPage calendarPage = new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions(){
        //we are reading username from.properties file
        String username = ConfigurationReader.getProperty("storemanagerusername");
        //we are reading password from.properties file
        String password = ConfigurationReader.getProperty("storemanagerpassword");


        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.repeatCheckboxLocator)).click();


        List<String > expectedOption = Arrays.asList("Daily", "Weekly", "Monthly");
        List<String> actualOption = calendarPage.getrepeatOptions();

        //correct way to check if 2 collections are equals
        Assert.assertEquals(actualOption, expectedOption);



    }
        //AfterMethod id coming from TestBAse

    }

