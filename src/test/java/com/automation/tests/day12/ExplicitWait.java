package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }

    @Test
    public void waitForTitle(){
        driver.get("http://google.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //put no more than 30 seconds usually

        //wait up to 10 seconds until title contains google
        //ExpectedConditions is a class , we use it for explicit wait;
        //ExpectedCondition is interface it's usage is different, we will use it in fluent wait
        wait.until(ExpectedConditions.titleContains("Google"));
        //when condition fails => we will get exception.
        //by default it will check every 500 milliseconds => means that it checked 20 times until find the element
        //Exception :
        //org.openqa.selenium.TimeoutException: Expected condition failed:
        //waiting for title to contain "Amazon". Current title: "Google" (tried for 10 second(s) with 500 milliseconds interval)

        driver.navigate().to("https://amazon.com");
        //Amazon's title is longer than amazon word so we did contains
        wait.until(ExpectedConditions.titleContains("Amazon"));

    //waitfotattributetobe element to be clikable presence
    }

    @Test
    public void waitForVisibility(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //if you have locator that points 2 element, it will point to first element if you do not specify.
        //to be more specific we can find it more specific like  by text => //button[text()='Start'] or button[1] etc..
        driver.findElement(By.tagName("button")).click();

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        //how do we wait for visibility of username
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        //normally we do not wait for the visibility of pasword or submit button/
        //once username is visible, everything else will be visible, too. We did just for practice
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        //until method returns webElement so we can send keys immediately.

        //wait until submit button element is visible then click
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual,expected);
    }


    @Test
    public void elementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));


        //overlay screen ==> (the screen that pops up while page is loading )
        //div element goes on top of page we have this page this screen, it will show up but not immediately there is a gap
        //selenium starts manipulating once load done, but there is a gap=> between loading complete - overlay screen pop up
        //submit button condition not helpful cause it becomes true even before overlay appears
        //so we put condition:
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));

        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        //once button is clickable we can enter username password
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitBtn.click();


        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
//element click intercepted:  something else was clicked instead of your element
//fluent wait is custom explicit wait
