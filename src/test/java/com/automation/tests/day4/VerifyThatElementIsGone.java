package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {

    /*
     Interview Question :

     how to check if element does not exist anymore in the DOM / or just does not exist at all ?

     DOM : document object model or that html code, HTML document in the browser
        How browser threats the HTML document? ==> it takes HTML code, converts HTML code in trio nodes,
        Every element its a node. DOM is API that converts that HTML real page. So it can manipulate with the page.
        delete elements, edit them..

     */
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        //how i will check ?
        //in our example, we suppose to delete that button, remove it from the page once we click on it ,
        //since find.elements return collection we can say .size it can be empty it is like a box, box can be empty, can be full
        //but in findElement it returns object. Object is exist or not. If does not exist so we get NoSuchElementException
        if(driver.findElements(By.id("disappearing_button")).size() == 0) {
            //if the size is 0 , that means no elemens were found
            //we can do isEmpty too
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        //we can do it in more steps if above is complicated : same thing
        //List<WebElement> list = driver.findElements(By.id("disappearing_button"));
        // if(list.size() == 0) {
        //            System.out.println("TEST PASSED");
        //        }else {
        //            System.out.println("TEST FAILED");
        //        }

        Thread.sleep(2000);

        //now we will find all buttons and click on them, after we deleted one already
        //to find all buttons ==>  findElements   <-------- ending "s" is important
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for(WebElement button : buttons){
            //vlick on every button
            button.click();
            Thread.sleep(2000);
            //in here we did not refresh or navigate another page don't need to find element again
        }

        driver.quit();

    }
}
