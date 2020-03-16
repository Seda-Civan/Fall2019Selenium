package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    /**
     * HOMEWORK : IMPROVE THIS METHOD!
     * This method returns webDriver object based on browser type
     * If you want to use ChromeBrowser just provide chrome as a parameter
     *
     * @param browserName
     * @return WebDriver object
     */
    public static WebDriver createDriver(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            //to fix [1583364253.052][SEVERE]: Timed out receiving message from renderer: 0.100
            WebDriverManager.chromedriver().version("79").setup();
            return new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }


        //switch case version of this method
    /*
      public static WebDriver createADriver(String browserName){
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                return null;
        }
    }
     */

    }
}