package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{

        //to start selenium script we need:
        //setup WebDriver (browser driver) and create web driver object
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //in Selenium everything starts from WebDriver interface
        //Chrome extends RemoteWebDriver  --> implements WebDriver
        //every ChromeDriver IS-A WebDriver

        String url = "http://google.com";
        //.get will open website, open the door
        driver.get(url);

        /* my practice code
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("hello world");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();
        */

        //to maximize browser
        driver.manage().window().maximize();
        //there is an option to make it fullscreen also, but usually we do not use it that much
       // driver.manage().window().fullscreen();

        //for demo, wait 3 seconds
        Thread.sleep(3000);

        //method that return page title
        //you can also see it as tab name, in the browser
        //returns <title>Some title</title> text
        String title = driver.getTitle();
        System.out.println("title is ..." +title);
        String expectedTitle = "Google";

        //What is our test now? we will test the title
        //equals is more accurate than contains
        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED !");
        }else{
            System.out.println("TEST FAILED !");
        }

        //go to another website within the same window
        driver.navigate().to("http://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone x 16gb");
        driver.findElement(By.className("nav-input")).click();

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed ! ");
        }else{
            System.out.println("Test failed !");
        }

        //comeback to google
        driver.navigate().back();

        //checking if page title is equals to google
        //getTitle() returns page title
        verifyEquals(driver.getTitle(), "Google");

        //move forward in the browser history
        //again, going to amazon
        driver.navigate().forward();

        Thread.sleep(3000);//for demo wait 3 seconds

        System.out.println("Title = " + driver.getTitle());


        System.out.println("current URL = " + driver.getCurrentUrl());
        driver.navigate().refresh(); //to reload the page

        Thread.sleep(3000);

        //must be at the end
        driver.close();//to close browser
        //browser can not close itself

    }


    /**
     * Check if to strings are same. If print TEST PASSED! message.
     * Otherwise, print TEST FAILED message
     * @param arg1
     * @param arg2
     */
    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
    }
}
