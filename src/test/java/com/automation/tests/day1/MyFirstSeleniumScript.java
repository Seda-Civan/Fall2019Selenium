package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {

        //set up chrome driver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
