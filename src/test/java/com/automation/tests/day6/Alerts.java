package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        //****************** FIRST BUTTON ********************
        buttons.get(0).click(); //to click on first button
        BrowserUtils.wait(2);
        //to get text from popup message
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);
        //to switch alert
        driver.switchTo().alert().accept(); //to click ok

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        //it will fail there is a typo on this word => successfuly => l is missing
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }

        BrowserUtils.wait(3);


        //****************** SECOND BUTTON ********************
        buttons.get(1).click();//to click on the 2nd button
        BrowserUtils.wait(3);
        //to click cancel
        driver.switchTo().alert().dismiss(); // result must be: You clicked: Cancel
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual:   "+actual2);
        }

        BrowserUtils.wait(3);

        System.out.println("task 3");
        //******************** TASK **********************
        //CLICK ON BUTTON 3
        //enter some text: Hello, World!
        //verify that result text ends with Hello, World!

        buttons.get(2).click();
        BrowserUtils.wait(3);

        driver.switchTo().alert().sendKeys("Hello, World!");
        BrowserUtils.wait(3);
        driver.switchTo().alert().accept();

        String expected3 = "You entered: Hello, World!";
        String actual3 = driver.findElement(By.id("result")).getText();

        if(expected3.endsWith(actual3)){
            System.out.println("TEST PASSED");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual:   "+actual3);
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual:   "+actual3);
        }

        /*
            System.out.println("TEST #3");
        //TASK for 5 minutes until 3:37: click on button #3
        //Enter some text: Hello, World!
        //Verify that result text ends with Hello, World!
        buttons.get(2).click();
        BrowserUtils.wait(3);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, World!");//enter text
        alert.accept();// click ok
        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, World!";
        if(actual3.endsWith(expected3)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual:   "+actual3);
        }
         */







        BrowserUtils.wait(3);
        driver.quit();



    }
}
