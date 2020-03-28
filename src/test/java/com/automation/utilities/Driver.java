package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//DriverFactory class was given us new driver object every time
//Driver class will give same driver object every time
public class Driver {

    //private static = same for everyone
    private static WebDriver driver;

    //so no one can create object of driver class
    //everyone should call static getter method instead
    private Driver(){

    }

    //we get browser type from configuration
    public static WebDriver getDriver(){

       //how to make sure webdriver created only once at the beginning
        //if webdriver object does not exist; create it
        if(driver == null){
            //specify browser type in configuration.properties file
            String browser =  ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            //close browser
            driver.quit();
            //destroy browser
            driver = null;
        }
    }
}


/*Emre abinin
public static WebDriver createADriver(Browser browser){
    WebDriver selectedDriver = null;
    switch (browser){
        case Chrome:
            WebDriverManager.chromedriver().setup();
            selectedDriver  = new ChromeDriver();
            break;
        case FireFox:
            WebDriverManager.firefoxdriver().setup();
            selectedDriver  = new FirefoxDriver();
            break;
        case MicrosoftEdge:
            WebDriverManager.edgedriver().setup();
            selectedDriver = new EdgeDriver();
            break;
        case Safari:
            selectedDriver = new SafariDriver();
            break;
    }
   return selectedDriver;
}}
 */