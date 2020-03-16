package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//this class will be used to create test case
//click on black button verify if is was successfully selected
public class RadioButtonsTest_2 {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //once you maximize window all elements will be visible, selenium will not give error
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //<input type="radio" id="black" name="color">
        //to get one specific element(in here black button) we use => findElement
        //black button's id only belongs to black button
        WebElement blackButton = driver.findElement(By.id("black"));

        //button is exists and visible are two different thing !!!  :
        //Checking if the button is exist => with findElements() method : if collection is empty element does not exist
        //isDisplayed() checks : element exist already and visible
        //some elements can be exist in html code but not visible to the user so we check if it is visible or not
        //isDisplayed returns true if element is visible. Applies to any kind of webElement, not only radio buttons
        //We will check if button is visible => isDisplayed(); and eligible to click => isEnabled();  :
        //like this :
        //  boolean visible = blackButton.isDisplayed();   boolean enabled = blackButton.isEnabled();
        //if (enabled && visible){
        // or like below :
        if(blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackButton.click();
        }else{
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }
        BrowserUtils.wait(2);


        System.out.println("has black button selected ?: "+blackButton.isSelected());
        System.out.println("has black button enabled ?:" +blackButton.isEnabled());

        //how do we verify that button clicked ?
        //returns true, if button clicked
        if(blackButton.isSelected()){
            System.out.println("TEST PASSED !");
        }else{
            System.out.println("TEST FAILED !");
        }


    driver.quit();

    }
}
