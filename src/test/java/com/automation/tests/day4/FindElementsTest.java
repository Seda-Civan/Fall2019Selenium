package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3);

        //how to collect all links from the page?
        //every link has a tagname a if you want to collect al of them ;
        //findElements() => returns collections of elements
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();
            //we will open every link and come back
            //  link.click();      //click on link
            //  Thread.sleep(2);
            //  driver.navigate().back();  //go back
        }
        //above code gave us this below exception SO POPULAR EXCEPTION => INTERVIEW <=
        //What is StaleElementReferenceException ?  ==> occurs when element is not attached to the page anymore
        //what does it mean : there is a webElement but connection is lost
        //element is old ; selenium has that element but can not use it anymore,
        // HOW TO HANDLE IT ? ====>  to be able to use it => YOU NEED TO re-find element again
        //StaleElementReferenceException : meaning => selenium can not find previously located element
        //it happens when you are trying to manipulate or interact with element after page refresh or navigation
        //every time we need to refresh our collection

        //we will solve it with for loop : when do we use for loop:
        //in general for each loop can be used only for collections
        //and you are using when you do not care about when to start when to stop iteration and order
        //in for loop; you can start in reverse order, you can start in the middle, or wherever you desire
        //in our case i want to ignore first link because it brings us to home page=> it is not really bring us nowhere
        //it is useless SO => we will start from 2nd one
        for (int i = 1; i < links.size(); i++) {
            links.get(i).click();
            driver.navigate().back();
            //refresh list => at the end of iteration
            //whenever you refresh the page or you're going somewhere;
            //that list become outdated. Even though locators are correct, but every web element has some kind of id
            //some kind of reference number and it becomes invalid once you leave the page
            //so every time when we go back; we have to refresh page find all elements again and continue like this
            //find all elements and refresh by making it equals to driver assign to driver
            //we find all links again in here:
            links = driver.findElements(By.tagName("a"));

        }

        //What happens if element was not found? => in case of findElement
        //NoSuchElementException
        //What happens if element was not found? => in case of findElements
        //nothing, just you will get empty list

        //Interview Question : how to check if element does not exist anymore/ or just does not exist at all ?
                  //if you will use findElement => you will get exception
                 //try to use findElements and check if list has size 0 = check if collection is empty if yes means element does not exist
                 //if(driver.findElements(By.id("name").size()==0)){
                         //element does not exist!
                 }

        // findElements ==>> method to find 0+ elements. how many elements your locator pointing on you get them
        // findElement  ==>> only 1 element at a time. if there is no element by given locator => NoSuchElementException


        //we can solve in 2 steps also :
        //driver.findElements(By.tagName("a")).get(i).click();
        //driver.navigate().back();
    }
