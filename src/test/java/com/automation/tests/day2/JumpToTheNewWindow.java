package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); //whenever you created web driver object

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every window has some id, this id calls window handle
        //based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);

        //getWindowHandles()  - returns id's of all currently opened windows
        //Set - does not allow duplicates
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);
        //is sequence the same as windows represented?
        System.out.println("before switch :" +driver.getCurrentUrl());

        //since we have all windows and we know id of original window,
        //we can say switch to something that is not equals to old window id
        for(String windowId : windowHandles){
            //if it is not old window than switch
            if( !windowId.equals(windowHandle)){
                //to jump to the new window
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("After switch :" +driver.getCurrentUrl());

        //driver.close();

        driver.quit();


        //so window handle is same for all same URLs?
        //No, window handle is for window not particular
        //each new windows creates their own unique handles(numbers) right?

    }

    /**
     * this method helps to switch in between windows based on page title
     * @param pageTitle
     * @param driver
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){

        Set<String> windows = driver.getWindowHandles();

        for (String eachWindow : windows) {

            driver.switchTo().window(eachWindow);

            if(driver.getTitle().equals(pageTitle)){

                break;
        }

        }
    }
}
