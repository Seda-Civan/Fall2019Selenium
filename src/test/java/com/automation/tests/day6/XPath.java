package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPath {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        //Why XPath is useful ;we can use partial matching of attribute, beginning of attribute, many different things
        //so we use xpath when we can’t find other unique locators like with id or name
        //when other attributes are not reliable

        //syntax for XPath =>  //tagname[@attribute='value']
        //value can be inside single quotes or double quotes
        // if you don't know the tagname or want to skip tagname use *
        // * means any tagname
        //for example //*[@onclick='button1()']

         /*
        Relative xpath -> // when we see two front slashes, it is relative xpath
        Format:
        //button[text()=‘Click for JS Alert’]
        tag name – attribute – value of attribute
        value can be between ‘ ’ or ” ”
        if you don’t know the tag name, or want to skip tag name, use *
        for example //*[@onclick=‘button1()‘] | * means any tag name
           //button[@onclick=‘button1()’] - original (edited)
         */

        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick=\"button1()\"]"));
        btn1.click();


        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        BrowserUtils.wait(3);


        //click on button 2
        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();
        System.out.println(result.getText());

        // //click on button 3

        WebElement btn3 = driver.findElement(By.xpath("//button[starts-with(@id,'button_')] "));
        btn3.click();
        System.out.println(result.getText());

        WebElement btn4 = driver.findElement(By.xpath("//button[contains(@id,'_button')][1]"));
        btn4.click();
        System.out.println(result.getText());
        WebElement btn5 = driver.findElement(By.xpath("//button[contains(text(),'5')]"));
        btn5.click();
        System.out.println(result.getText());


        /*
        //button[@class='btn btn-primary']   or  //*[@class='btn btn-primary']
        //button[@onclick='button4()']  => find a button with onclick vslue button4()
        //button[@id='btnbtn_button'] => find a button, with id btnbtn_button
        //button[text()='Button 4']  => => find a button, with text Button 4

      devamini notlardan al
        //tag[@attribute='value']

        //button[starts-with(@id,'button_')] -- to match beginning of attribute
        //tag[starts-with(@attribute,'button_')]

         */
        BrowserUtils.wait(3);
        driver.quit();
    }
}
