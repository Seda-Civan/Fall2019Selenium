package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes_3 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        //find all checkboxes
        //<input type="checkbox" checked="">
        List<WebElement> checkBoxes =  driver.findElements(By.tagName("input"));

        //checkBoxes.get(0).click(); //click on first checkbox
        BrowserUtils.wait(2);
        //checkBoxes.get(1).click(); //click on second checkbox
        //second one is already checked by default, it will de-select

        //we will write a logic that if checkbox is already selected, don't click on it.
        //if not then click :
        //go over collection of checkboxes
        for (int i = 0; i < checkBoxes.size(); i++) {
                     //if visible,                eligible to click and (intractable)         not clicked yet           ==>  then click
            if(checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() &&  (!checkBoxes.get(i).isSelected())){
                //if checkbox is not selected,  click on it
                checkBoxes.get(i).click(); //click on second check box
                System.out.println(i+1 +". checkbox clicked!");

            }else{
                System.out.println(i+1 +". checkbox is already selected, so we did not click!");
            }
        }
        BrowserUtils.wait(3);
        driver.quit();

    }
}
