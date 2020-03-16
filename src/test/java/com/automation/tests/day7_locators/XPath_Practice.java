package com.automation.tests.day7_locators;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPath_Practice {

    //list of all locators store them in interface at work
    //to make code more organized we make this locator reusable
    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    public static String loginBtnLocator = "//button[contains(text(), 'Login')]"; //we can even write L it will find since it is contains
    ////button[@type='submit' or @id='wooden_spoon'] we can do like this too

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();




        ////label[text()='Username']/following-sibling::input


        BrowserUtils.wait(3);
        driver.quit();

    }
}
