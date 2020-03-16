package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons_1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        //in utilities package ; inside browserUtils class we created Thread.sleep and handled already
        //so we called it in here
        BrowserUtils.wait(2);

        //every single radio button have tagName input
        //<input type="radio">
        //input we can search like this too
        //we will find all radio buttons then click one by one ->
        //how can we find => we can use tagName input since all of them have
        //and there is no other buttons in this page other then radio we don't need to specify - input is enough
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        //every single radio button has attributes
        for (WebElement radioButton : radioButtons) {

            //<input type="radio" id="red" name="color">
            String id = radioButton.getAttribute("id"); //returns red

            //returns true if button already clicked => to check button is already clicked?
            //if button is already clicked : you can click and un-select especially in checkboxes
            //but this does not work on radio buttons, if it's clicked if you click again nothing happens
            boolean isSelected = radioButton.isSelected();
            System.out.println(id + " is selected? "+ isSelected);

            //to check if button can be clicked / if button is eligible to click??
            //just to know what was clicked what was not clicked
            //returns true if you can click on that button
            //we can check all buttons id since in this case all buttons have id
            if (radioButton.isEnabled()) {
                //isEnabled() returns boolean
                //if true means button can be clicked, then we will click below:
                radioButton.click();
                System.out.println("Clicked on :: " + id); // created variable for this -->  radioButton.getAttribute("id"));
                BrowserUtils.wait(1);

            } else {
                System.out.println(id+"button is disabled, can not clicked :: " + id);
            }
            System.out.println();
        }


            driver.quit();


        }
    }
