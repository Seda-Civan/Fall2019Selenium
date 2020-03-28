package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
    /*

    Why  use synchronize ?

    NoSuchElementException : most likely because of synchronization issues

    => it means you code is running faster than your browser while loading your web application
    or it's maybe on web application side, web application is loading element too slow
    =>or Element appears on the HTML (DOM) after certain time
    =>or Element is in the HTML (DOM) but visible after certain time
    so you failing when you manipulate with them
    StaleElementException, ElementIsNotClickableException, ElementIsNotIntractableException.. there are bunch of webDriverExceptions..

    ***** How to solve ? ******

    ______1. Thread.sleep______

     it put on pause your java program, too much usage make the test long and heavy (do not use)


    ______2. Implicit wait_____

     driver.manage().timeouts().implicitWait(10, TimeUnit.SECONDS)

     once page is loaded selenium is try to manipulate with the element.
     And if selenium for some reason can not find the element by given locator , selenium will throw NoSuchElementException
    because implicit wait is by default set to 0(zero)


     - makes driver continue polling the DOM for the duration specified - if element found it will stop polling
     "to poll the DOM".What exactly it means?
        It means to check the DOM repeatedly, on a set interval (every X milliseconds), to see if an element exists

     - Implicit wait have to be specified only once

     - it will work always after loading webpage

     - stop polling as soon as the element is found
     will throw exception after the time expires if element is not found

     -will apply until the end of webDriver (till ypu quit or close)



     _______3. Explicit Wait______

     WebDriverWait wait = new WebDriverWait(driver, 10); //10 seconds

     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
     -will wait 10 seconds using the locator provided

     -only applies once when that line called

     -will continue waiting if the element is loaded but not clickable

     more custom wait to handle synchronization issues

     explicit wait only works with elementNotFoundException
     - wait until element is visible
                             available
                             clickable
                             available



     */