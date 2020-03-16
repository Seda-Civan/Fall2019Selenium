package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame_5 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);

        //before looking for that element, we need to jump to that frame
        //we have method to jump to that frame to see inner html document
        driver.switchTo().frame("mce_0_ifr");
        //you can specify name id, index or web element of the frame
        //it is like we are jumping to another layer
        //now this content (textInput) will be visible
        //textInput  <---- this element located inside iframe first we looked up for frame it has id
        WebElement textInput = driver.findElement(By.id("tinymce"));

        System.out.println(textInput.getText());
        // https://www.seleniumhq.org/exceptions/no_such_element.html throwed this
        //because selenium could not see the content, frame is layered, not visible
        //you have to switch to the frame we need to know how t locate the frame

        //weneed to do this manipulations inside frame, before we go out
        //to delete text which is already there in this case text is to be cleared : Your content goes here.
        textInput.clear();
        //to enter text :
        textInput.sendKeys("hello, world!");
        BrowserUtils.wait(4);

        //exit from the frame
        driver.switchTo().defaultContent();

        //bunu distaki frame e cikinca yazdirabiliriz
        //if we want to read the text on heading first we have to go out from inner html document
        //if we don't exit from the frame ==> we get exception => NoSuchElementException
        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println("heading is = " + heading.getText());
        //purple tag orange attribute blue value of attribute black text
        /*
         -->> Purple is tag
         -->> Brown/orance is attribute
         -->> Blue is value of attribute
         -->> Black is text

         */

        driver.quit();
    }
}
