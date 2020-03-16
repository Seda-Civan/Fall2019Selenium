
package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest_4 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        //#TASK
        //verify that 1st checkbox is not selected and 2nd is selected (by default)
        BrowserUtils.wait(4);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        BrowserUtils.wait(2);

        //let's click on the first checkbox and verify it's clicked
        //since we did not have any kind of navigation's or page refreshments => our collection is still valid we can use those web elements
//        checkBoxes.get(0).click();
        //above is one line solution or we can do below :
        WebElement checkbox1 = checkBoxes.get(0); //to get 1st checkbox
        checkbox1.click();//click on it

        BrowserUtils.wait(2);
        //i need to verify that first checkbox selected after i click on it :
        if(checkbox1.isSelected()){
            System.out.println("TEST PASSED");
            System.out.println("checkbox #1 is selected");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("checkbox #1 is not selected!");
        }


        driver.quit();
    }
}