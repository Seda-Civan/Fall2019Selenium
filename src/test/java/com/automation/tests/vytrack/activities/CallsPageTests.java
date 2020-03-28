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
import static org.testng.Assert.*;

public class CallsPageTests {

    /*
    Scenario: Verify for store manager
    Login as story manager

    Go to Activities --> Calls
    Verify that Log Call button is displayed

     */


    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUserName="storemanager55";
    private String storeManagerPassword="UserUser123";
    private By activitiesBy = By.xpath("//span[@class=\"title title-level-1\" and contains(text(),\"Activities\")]");
   // private By logCallBtnBy = By.cssSelector("a[title=\"Log call\"]");
    //or below same
    private By log = By.partialLinkText("Log Call");

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
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);

    }

    @Test
    public void verifyLogButton(){

        //Verify that Log Call button is displayed
        WebElement logCallBtnElement = driver.findElement(log);
        assertTrue(logCallBtnElement.isDisplayed());
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
