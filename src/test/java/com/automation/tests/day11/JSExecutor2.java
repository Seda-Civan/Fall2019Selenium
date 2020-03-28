package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void verifyTitle(){
        String expected = "Practice";
        //we create javaScrptExecutor object by casting webDriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //executeStript - this method executes javaScript code
        //we provide code as a String
        //return document.title - javascript code
        //document represents HTML page
        ///Call .toString() method to avoid casting from Object to String (upcasting) :
        //String actual =  js.executeScript("return document.title").toString();
        String actual = (String) js.executeScript("return document.title");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void clickText(){
       WebElement link =  driver.findElement(By.linkText("Multiple Buttons"));
 //      disabled this click action, to perform it with js executor
 //      link.click();

       JavascriptExecutor js = (JavascriptExecutor) driver;
        //after double quotes you can list webElements that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //class name... args ==>  like array
        //lets us specify 0 or more webElements there is no limit
        //arguments -  will be listed after comma, as a list
        //use index to get specific webElement
        //WebElement arguments = { element, link , link2};
        //from left to right
       js.executeScript("arguments[0].click()", link);
       //it you look for first element then 0

       WebElement button6 = driver.findElement(By.id("disappearing_button"));
       js.executeScript("arguments[0].click()", button6);
       BrowserUtils.wait(2);
       WebElement result = driver.findElement(By.id("result"));
       Assert.assertEquals(result.getText(), "Now it's gone!");
    }

    @Test
    public void textInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //to get text from input box - read attribute "value"
        //to enter text - set attribute "value"
        //.setAttribute('value' , 'text') - enter some text
        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')" , username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')" , password);
        js.executeScript("arguments[0].click()", loginBtn);
        BrowserUtils.wait(4);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        Assert.assertEquals(expected, subheader);
    }

    @Test
    public void scrollToElement(){
        //href = link, URL
        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", link);
    }

    @Test
    public void scrollTest(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        //navigate().to() method calls get method, =>  within same window to go another url

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll 15 times each time 1000 pixel
        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0,1000)");
            BrowserUtils.wait(1);

        }
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

}
