package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        //Which programming languages do you know?
        //Java JavaScript C# Python Ruby C
        //above option is let user select multiple options
        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        //whether this select element support selection multiple options at the same time ?
        //this is done by checking the value of the "multiple" attribute
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple); //=> if it's true, you can select more than one option

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        //let's get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for(WebElement selectedLanguage : selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }

        BrowserUtils.wait(3);

        //to unselect something
        languagesSelect.deselectByVisibleText("Java");
        BrowserUtils.wait(3);
        //deselect everything
        languagesSelect.deselectAll();



        BrowserUtils.wait(3);
        driver.quit();
    }
}
