package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //when do we select by value when by text ?
        //mostly people select by text, value is invisible so first you need to go to source code
        //text is visible
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        //comes from inspect value "GA"
        stateSelect.selectByValue("GA");

        //verify if you selected GA
        String expected = "Georgia";
        //.getFirstSelectedOption() returns a webElement(what we select) thats why we need to call getText() method to be able to compare it with a string
        String actual = stateSelect.getFirstSelectedOption().getText();

        BrowserUtils.wait(3);
        if(expected.equals(actual)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }





        BrowserUtils.wait(3);
        driver.quit();
    }
}
