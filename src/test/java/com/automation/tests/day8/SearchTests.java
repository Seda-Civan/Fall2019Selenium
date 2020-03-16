package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
       driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tagname h3 its the easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
           String var = searchItem.getText();
           //search item must have text if not then it is not search item
           //if thee is a text - print it
            if(!var.isEmpty()){
                System.out.println(var);
                //verify that every search result contains java
                //test without assertion is useless - what makes test => test
                //without assertion you can not understand test has passed or failed
                //is some of the search results
                //doesn't contain java word, it will fail the test
                Assert.assertTrue(var.toLowerCase().contains("java"));
                System.out.println(var.toLowerCase());
                System.out.println();
            }
        }
    }

    /**
     * Given user is on the amazon.com page
     * When user enters "java" as a search item
     * Then user clicks on the search button
     * And user clicks on the first search item
     * And user verifies that title of the search item contains "Java"
     */
    @Test(description = "Search for Java book on amazon")
    public void amazonSearchTest(){

        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        List<WebElement> searchItems = driver.findElements(By.xpath("//a[@class=\"a-link-normal a-text-normal\"]"));
        searchItems.get(0).click();
        BrowserUtils.wait(3);
        String title = driver.findElement(By.id("ebooksProductTitle")).getText();

        Assert.assertTrue(title.toLowerCase().contains("java"));



    }


    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy driver object
       driver.quit();
    }
}
