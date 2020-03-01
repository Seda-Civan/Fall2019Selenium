package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{

        //to start selenium script we need:
        //setup webdriver (browser driver) and create web driver object
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //in Selenium everything starts from WebDriver interface


        String url = "http://google.com";
        //.get will open website, open the door
        //Chrome extends RemoteWebDriver  --> implements WebDriver
        driver.get(url);

        //for demo, wait 3 seconds
        Thread.sleep(3000);

        //method that return page title
        //you can also see it as tab name, in the browser
        //returns <title>Some title</title> text
        String title = driver.getTitle();
        System.out.println("title is ..." +title);

        String expectedTitle = "Google";
        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED !");
        }else{
            System.out.println("TEST FAILED !");
        }

        //to close browser
        driver.close();

    }
}
