package com.automation.tests.homework.hw_3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_9to12 {

    /*
    Optional: If you want to to be a real selenium hero, use @DataProvider for for tests cases from 9 through 12.
    Please use following documentation: https://testng.org/doc/documentation-main.html#parameters-dataproviders

    Test case #9
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “200”.
    Step 4. Verify that following message is displayed: “This page returned a 200 status code”

    Test case #10
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “301”.
    Step 4. Verify that following message is displayed: “This page returned a 301 status code”

    Test case #11
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 3. And click on “Status Codes”.
    Step 4. Then click on “404”.
    Step 5. Verify that following message is displayed: “This page returned a 404 status code”

    Test case #12
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 3. And click on “Status Codes”.
    Step 4. Then click on “500”.
    Step 5. Verify that following message is displayed: “This page returned a 500 status code”
     */

    private WebDriver driver;
    String url = "https://practice-cybertekschool.herokuapp.com";
    private By statusCodesBy = By.linkText("Status Codes");
    private By code200By = By.linkText("200");
    private By code301By = By.linkText("301");
    private By code404By = By.linkText("404");
    private By code500By = By.linkText("500");
    private By verifyMessageBy = By.tagName("p");

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get(url);
        BrowserUtils.wait(2);
        driver.findElement(statusCodesBy).click();
    }

    @Test (description = "Verify status codes message" , dataProvider = "testData")
    public void verifyStatusCodes(By codeBy , String expectedMessage){

        driver.findElement(codeBy).click();
        WebElement verifyMessage = driver.findElement(verifyMessageBy);
        String actual = verifyMessage.getText();
        assertTrue(actual.contains(expectedMessage));
    }

    @DataProvider (name = "testData")
    public Object[][] testData(){
        return new Object[][] {
                {code200By , "This page returned a 200 status code"},
                {code301By , "This page returned a 301 status code"},
                {code404By , "This page returned a 404 status code"},
                {By.linkText("500") , "This page returned a 500 status code"}
        };
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }



}
