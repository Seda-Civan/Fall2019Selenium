package officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SeleniumOH1 {

    public static void main(String[] args) throws InterruptedException {


        /*
        1. Go to http://automaticpractice.com
        2. Search for t-shirt in a search box + click enter or click search button
        3. validate you got 'no results' message on UI
        4. Search for t-shirt
        5/ Validate there was 1 result found
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();


        WebElement search_box = driver.findElement(By.id("search_query_top"));
        //WebElement - interface in selenium/java and it has many useful methods
        //.sendKeys("value that we want to send  - input")
        Thread.sleep(3000);
        search_box.sendKeys("tshirt" + Keys.ENTER);
        //Keys is enum : final values

        //<p class="alert alert-warning">
        //					No results were found for your search&nbsp;"tshirt"
        //			</p>

        Thread.sleep(3000);
        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText = error.getText();
        //.getText();  =>> returns String(text) from the element
        System.out.println(errorText);

        search_box = driver.findElement(By.id("search_query_top"));
        search_box.clear();
        //.clear() - (void) it will delete any values from input
        search_box.sendKeys("t-shirt" + Keys.ENTER);
        //StaleElementReferenceException - element is old/stale - we want to find
        //this element again OR refresh page

        Thread.sleep(4000);
        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found " + count.getText());




        Thread.sleep(2000);

        //<a class="button ajax_add_to_cart_button btn btn-default"
        // href="http://automationpractice.com/index.php?controller=cart&amp;add=1&amp;id_product=1&amp;token=e817bb0705dd58da8db074c69f729fd8"
        // rel="nofollow" title="Add to cart" data-id-product="1">
        //										<span>Add to cart</span>
        //									</a>


        Actions actions = new Actions(driver);
        WebElement result=driver.findElement(By.className("replace-2x img-responsive"));
        actions.moveToElement(result);
        Thread.sleep(3000);



       WebElement addToCart = driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
       addToCart.click();




        Thread.sleep(3000);
        driver.quit();


    }
}

