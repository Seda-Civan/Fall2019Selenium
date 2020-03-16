package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);
        WebElement upload = driver.findElement(By.id("file-upload"));
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        //String filePath = System.getProperty("user.dir")+"/pom.xml";
        //for which files we can use this ?
        //System.getProperty("user.dir")
        //returns location of your project
        //i think it is to copy the path to current directory
        //so your project is running from some specific folder, and this method locates the path to that project
        //but it will not give you the name of project, that's why he added "pom.xml"
        String filePath = "/Users/sedacivan/IdeaProjects/Fall2019Selenium/pom.xml";


        System.out.println(filePath);
        upload.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(5);
        driver.quit();
    }

}
