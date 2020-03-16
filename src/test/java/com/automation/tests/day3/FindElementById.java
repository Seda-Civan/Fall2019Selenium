package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");

        //shortening, we used directly. did not crate reference variable
        //but we use it once then can not use it anymore that's why we create variables
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        //created reference variable then used password element
        //if you want to use element more then once create variable first
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //FINDING ELEMENTS BY <a> LINK TEXT
        //let's click on Logout button. It looks like a button, but it's actually a link
        //every element with <a> tag is a link, a element stands for link
        //if you have couple spaces in the text, just use partialLinkText instead of linkText
        //linkText - equals()
        //partialLinkText - contains() - complete match doesn't required
        //don't put space
        WebElement logout = driver.findElement(By.partialLinkText("Logout"));

        //To which page we will go when we click logout button? what is the url ?
        //how to read specific attribute? like href?  ==> getAttribute("attributeName") method
        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");

        System.out.println(href);
        System.out.println(className);

        logout.click();
        Thread.sleep(2000);

        //let's enter invalid credentials
        //in above since we did not create reference variable, we have to find elements again
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        //When we enter invalid credentials; we will get error message. Let's read this message;
        //find this error message element by id
        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());

        Thread.sleep(2000);
        driver.quit();
    }
}