package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.*;

public class CalenderEventsPageTests {

     /*
     Task
     Scenario: Verify for store manager

     Login as story manager

     Go to Activities --> Calendar Events
     Verify that Create Calendar Event button is displayed
      */


        private By usernameBy = By.id("prependedInput");
        private By passwordBy = By.id("prependedInput2");
        private WebDriver driver;
        private Actions actions;

        private String storeManagerUserName="storemanager55";
        private String storeManagerPassword="UserUser123";
        private By activitiesBy = By.xpath("//span[@class=\"title title-level-1\" and contains(text(),\"Activities\")]");
        private By createCalenderEventBtnBy = By.cssSelector("a[title=\"Create Calendar event\"]");
    // css selectoer =>>
    // # means id
    // > means direct child
        private By currentUserBy = By.cssSelector("#user-menu >a");
        private By ownerBy = By.id("s2id_oro_calendar_event_form_calendar");
        //or below
        //driver.findElement(By.className("select2-chosen")).getText().trim()
        private By titleBY = By.cssSelector("[name=\"oro_calendar_event_form[title]\"]");
        //for some reason id is always different, that's why we used contains (*) to partially match id.
       //We selected static part of id and provided into locator, we did not take number parts
        private By startDateBy = By.cssSelector("[id*=\"date_selector_oro_calendar_event_form_start-uid\"]");
        private By startTimeBy = By.cssSelector("[id*=\"time_selector_oro_calendar_event_form_start-uid\"]");


        @BeforeMethod
        public void setup(){
            driver = DriverFactory.createDriver("chrome");
            driver.get("http://qa2.vytrack.com/user/login");
            //if you put https => if page is not secure it will give error put http
            driver.manage().window().maximize();

            actions = new Actions(driver);
            //before using actions class create webdriver object. because you have to pass driver to actions class consructor

            BrowserUtils.wait(3);
            //do not use this Thread.sleep at work.
            driver.findElement(usernameBy).sendKeys(storeManagerUserName);
            driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
            BrowserUtils.wait(5);
            //how we hover-over on something => action class and it comes from selenium

            //once we create actions object we can do hover-over Activities
            actions.moveToElement(driver.findElement(activitiesBy)).perform();
            BrowserUtils.wait(3);
            driver.findElement(By.linkText("Calendar Events")).click();
            BrowserUtils.wait(5);

        }

        @Test
        public void verifyCreateButton(){

            WebElement createCalenderEventBtn = driver.findElement(createCalenderEventBtnBy);
            assertTrue(createCalenderEventBtn.isDisplayed());
        }

        /*
        //we have these steps in the before method:
        Test Case: Default options
        Login as sales manager
        Go to Activities --> Calendar Events

        Click on Create Calendar Event
        Default owner name should be current user
        Default title should be blank
        Default start date should be current date
        Default start time should be current time
        NOTE //specify todays date tomorrows date important at work dynamic date not hardcoded
         */
        @Test
        public void verifyDefaultValues(){
            //Click on Create Calendar Event
            driver.findElement(createCalenderEventBtnBy).click();
            BrowserUtils.wait(3);

            //Default owner name should be current user
            String currentUserName = driver.findElement(currentUserBy).getText();
            String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
            assertEquals(currentUserName,defaultOwnerName);

            //Default title should be blank
            WebElement titleElement = driver.findElement(titleBY);
            assertTrue(titleElement.getAttribute("value").isEmpty());
            //there is no value attribute itself, thats why isEmpty gives us true ?

            //date time syntax
            //Default start date should be current date
            String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            //String today = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
            String actualDate = driver.findElement(startDateBy).getAttribute("value");
                    //this is input box does not have text, it has value, so we need to getAttribute
            assertEquals(actualDate,expectedDate);
            //Assert.assertEquals(currentDate, (date.getAttribute("value")+" "+time.getAttribute("value"))); buna bak

            //Default start time should be current time
            String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
                    //put the time into format
            String actualTime = driver.findElement(startTimeBy).getAttribute("value");
            assertEquals(actualTime,expectedTime);
            /*

            java.lang.AssertionError: expected [9:46 PM] but found [6:46 PM]
            Expected :9:46 PM
            Actual   :6:46 PM
            <Click to see difference>
            =====>>>>  assertEquals(actualTime,expectedTime);  we found bug
             */




            //time zones are not same => so people use local time


        }

        @AfterMethod
        public void teardown(){
            driver.quit();
        }
    }


