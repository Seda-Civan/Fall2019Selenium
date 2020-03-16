package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTests {

    /**
     * Create a class called PracticeTests
     * - setup before/after methods
     * 	- in before method. instantiate webdriver and navigate to: http://practice.cybertekschool.com/
     * 	- in after method - just close webdriver.
     * - create a test called loginTest
     * 	- go to “Form Authentication” page
     * 	- enter valid credentials
     * 	- verify that following sub-header message is displayed: “Welcome to the Secure Area. When you are done click logout below.”
     */

    private WebDriver driver;

    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void loginTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

        String actual = driver.findElement(By.className("subheader")).getText();
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters : (expected, actual, message in case of error)
        //assert method is overloaded
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");

    }


        @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION : HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //use chromeoptions and use setAcceptInsecureCerts(true) method
        //ChromeOptions - use to customize browser for tests
        //so we manipulate with chromeOptions our chrome browser ?
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chtomeOptions abject into chromedriver constructor
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }


    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enters his email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed
     */
    @Test
    public void forgotPasswordTests(){
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.name("email")).sendKeys("cybertek@gmail.com",Keys.ENTER);
        BrowserUtils.wait(2);
        String actual = driver.findElement(By.tagName("h4")).getText();
        String expected = "Your e-mail's been sent!";

        Assert.assertEquals(actual,expected);

    }

    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Checkboxes" page
     * And clicks on checkbox #1
     * Then user verifies that checkbox #1 is selected
     */

    @Test
    public void checkboxTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(3);
        driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(0).click();

        Assert.assertTrue( driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(0).isSelected());

    }


    @AfterMethod
    public void teardown(){
        //close browser and destroy driver object
        driver.quit();
    }

}
