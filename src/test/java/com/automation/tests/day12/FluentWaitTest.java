package com.automation.tests.day12;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void fluentWaitTest(){
        //overlay screen appears and disappears
        //this can be a problem, if we need to change pool ling time how often condition is true; we can use fluent wait
        //website is loaded, but loaded not completely ajax=> load partially
        //content can be updated without updating whole page
        //how do we create fluent wait?
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        driver.manage().window().maximize();

        Wait<WebDriver> wait = new FluentWait<>(driver).
                //10, TimeUnit.SECONDS  = Duration.ofSeconds(10)
                withTimeout(Duration.ofSeconds(10)).
                //check for condition every 3 seconds
                pollingEvery(Duration.ofSeconds(3)).
                //if NoSuchElementException happens, don't break, keep checking, we just handle the problem
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class).
                ignoring(ElementClickInterceptedException.class);


        //we create anonymus class
        //Function interface has method apply
        //in explicit wait every single method use this interface overrides apply method
        //has same code behind the scene
        //a class has no name = Anonymous class
        //because it’s an interface with no implementation, we have to override the apply method and provide our own implementation
//        WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver webDriver) {
//                return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
//            }
//        });
//
        //lambda version
        WebElement submitBtn = wait.until(driver -> driver.findElement(By.cssSelector("button[type=\"submit\"]")));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));

        driver.findElement(By.name("username")).sendKeys("tomsmith");

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        submitBtn.click();

    }

}
