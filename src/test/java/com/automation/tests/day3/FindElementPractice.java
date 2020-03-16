package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice {

    public static void main(String[] args) throws  Exception{

        //we are writing same codes again and again
        //we will write a method and call it : DRY Principle
        //sth that support our code : utilities
        //under automation package
        //We created utilities package and DriverFactory class under automation package
        //we wrote reusable methods inside DriverFactory class named => createDriver
        //whenever we need to crate webDriver object
        //we will call our custom method
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
         */

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));
        //we have By.tagName method also but it is a little risky
        //we have at least 2 input boxes in this website
        //so I can search for the boc by tagName locator, but it may give multiple locations.
        // to make things easier we use name locator
        fullName.sendKeys("Mister Twister");

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        Thread.sleep(2000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        signUp.click();
        //when you see type="submit", you can use submit() instead of click()
        //it make sense to use when click() method does not work
        //signUp.submit();

        Thread.sleep(2000);

        //we need to verify out test :
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        //we found the message by className, and className is subheader in this example
        //we could have find the message by tagName h3 and by name "signup-message' they were unique also
        WebElement message = driver.findElement(By.className("subheader"));
        //actual comes from web element
        //how to get text from web element ? ==> message.getText();
        //once you call this message it will return visible text of the element
        //visible text appear between opening and closing tag and visible to the user
        //to get the text => <h3>Text</h3>
        String actual = message.getText();


        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        driver.quit();//to close everything



    }



}


