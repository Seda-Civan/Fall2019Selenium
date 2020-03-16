package com.automation.tests.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

    public static void main(String[] args) {

    googleTest();

    }

    public static void googleTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://ebay.com");
        //driver.navigate().to("https://oogle.com"); same above method
        //getTitle() returns String
        String title = driver.getTitle();
        System.out.println("title = " + title);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       driver.findElement(By.xpath("//input[@placeholder=Search for anything]"));

        //driver.close();
    }
}
