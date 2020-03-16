package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);

        //we find web elements based on locators
        //By.name("q") --> name="q"
        WebElement search = driver.findElement(By.name("q"));
        ///if your element is not correct OR selenium can not find your element
        // you will get: NOsuchElementException


        //once we found element, how to enter the text?
        //to enter text, use sendKeys() method
        //how to press enter after entering the text?
        //use Key.ENTER
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);

        driver.quit();
    }
}
