package com.automation.tests.day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @Test(description = "Verify page title")
    public void test(){

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Assert.assertTrue(driver.getTitle().equals("Google"));
        driver.quit();
    }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{{"http://google.com", "Google"},
                              {"http://amazon.com", "Amazon"},
                              {"http://etsy.com", "Etsy"},
                              {"http://ebay.com", "Ebay"},
                              {"http://cybertekschool.com", "Cybertek"}
        };
    }
}
