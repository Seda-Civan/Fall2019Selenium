package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;

public class LoginPageTests {

    private WebDriver driver;
    //https is a secured version of http protocol
    //http = it's hypertext transfer protocol that every single website is using nowadays
    //https = data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text very easy to hack it
    private String url = "https://qa2.vytrack.com/user/login";
    //CREDENTIALS FOR STORE MANAGER
    private String username = "storemanager51";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    //by is class when you use element inside by you specify what you look
    //to find element you use By
    //private By usernameBy = By.id("prependedInput");  // By is a class--> when we find an element by using By.... methods
    ////it returns By data type and we stored it in to By as above statement.
    private By passwordBy = By.id("prependedInput2");
    //By.id("prependedInput2") == passwordBy => same thing
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");

    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invalidUsername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(2);
        WebElement warningElement = driver.findElement(warningMessageBy);
        //or  => assertTrue(driver.findElement(By.className("alert alert-error")).isDisplayed());
        assertTrue(warningElement.isDisplayed());
        //assertEquals(warningElement.getText(), "Invalid user name or password.");
        //since we did static import we drictly use static method without specifying classname

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual,expected);
    }

    @Test(description = "Login as store manager and verify that title is equals to dashboard")
    public void loginAsStoreMAnager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(2);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        //how to find title fastly : type title on inspect find part

        assertEquals(actual,expected, "Page title is not correct!");
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        //if webDriver object alive
        if(driver != null){
          //  close browser, close session
            driver.quit();
            //destroy webDriver object for sure
            //garbage collector destroy object when there are no reference
            //there is low chance to have sth wrong in this step==> driver.quit(); but we wrote driver=null anyway to prevent
            driver = null;
        }
    }
}
/*
html5 warning message attribute
this warning message can not be catched with locator
it some kind of attribute coming from html
you can not catch it, there is a method getAttribute
you can just read it
 */