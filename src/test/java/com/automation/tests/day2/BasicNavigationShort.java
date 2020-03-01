package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigationShort {

    public static void main(String[] args) throws InterruptedException{
        //to set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        //to create an object of ChromeDriver class
        ChromeDriver driver= new ChromeDriver();
        String url = "http://google.com";
        String url2 = "http://amazon.com";

        //will open browser with url
        //open google.com
        driver.get(url);

        //will put on hold current run on 3 seconds
        Thread.sleep(3000);

        //navigate to the amazon.com
        driver.navigate().to(url2);

        //wait for 3 seconds
        Thread.sleep(3000);

        //navigate back to the previous url
        //in our case it's google.com
        driver.navigate().back();

        //wait for 3 seconds
        Thread.sleep(3000);

        //navigate
        driver.navigate().forward();

        //wait for 3 seconds
        Thread.sleep(3000);

        //will refresh page
        driver.navigate().refresh();

        //wait for 3 seconds
        Thread.sleep(3000);

        //will close browser
        driver.close();

    }
}
