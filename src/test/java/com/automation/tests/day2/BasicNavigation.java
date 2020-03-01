package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) {

        //to start selenium script we need:
        //setup webdriver (browser driver) and create web driver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //in Selenium everything starts from WebDriver

        //will open website, open the door
        String url = "http://google.com";
        driver.get(url);


    }
}
