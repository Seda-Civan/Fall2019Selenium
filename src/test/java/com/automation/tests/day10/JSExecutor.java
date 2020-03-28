package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
 //       driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void scrollTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com/infinite_scroll");
        //how to use javaScriptExecutor?
        //javaScriptExecutor; it is an interface we can not create object out of it.
        //But javascript executor and webDriver are like siblings
        //So we will cast driver to JavascriptExecutor
        //we convert webDriver object into JavaScriptExecutor
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //interface => they don't have implementation
        //if you have interface as reference type you can see methods only coming from that interface
        //you can not see other methods that are in other interfaces
        //so we will use remoteWebDriver class as reference type :
        //if you use remoteWebDriver class as reference type you do not need to cast anymore, it has everything
        //like this => private RemoteWebDriver driver;
                    //driver.executeScript("window.scrollBy(0, 250)");
        //you need to cast if your reference type is webDriver; like this =>  private WebDriver driver;
                                                                            //JavascriptExecutor js = (JavascriptExecutor) driver;
        //abstraction = hiding implementation details
        //encapsulation = hiding instance fields
        //scroll down 250 pixels
        //x,y
        //driver.executeScript("window.scrollBy(0, 250)");

        //we will scroll 10 times
        for (int i = 0; i < 10 ; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(1);
    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        //scrollIntoView => java script method , scroll until this element becomes visible
        //arguments[0] => means 1st webElement after comma get the first one
        driver.executeScript("arguments[0].scrollIntoView(true)",link);
    }
}


    /*
    Why do we need JavaScriptExecutor?
    In Selenium WebDriver, locators like XPath, CSS, etc.
    are used to identify and perform operations on a web page.
    In case, these locators do not work you can use JavaScriptExecutor.
    You can use JavaScriptExecutor to perform an desired operation on a web element.
     */