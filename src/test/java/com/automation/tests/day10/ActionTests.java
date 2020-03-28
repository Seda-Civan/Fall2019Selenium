package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTests {

    private WebDriver driver;
    //(//img)[1]  means => 1st image. element itself. there was couple of element with same tagname, we put paranthesis ( ) to get first one
    //visibility and present is different
    private Actions actions;
    //Action class comes from Selenium, used for doing actions like drag and drop.. etc
    //Action class implements the builder pattern to create composite action containing a group of other actions
    //Builder pattern = you can chain actions, methods, so we can perform them as one event, we can group them
    //how to use actions class, we create object out of it
    //Some image normally does not visible, when we do hover over action it is visible => we can hover over with actions class

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver); //setup actions object to hover over
    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

         /*
        List<WebElement> images = new ArrayList<>(Arrays.asList(driver.findElement(By.xpath("(//img)[1]")),
        driver.findElement(By.xpath("(//img)[2]")),
        driver.findElement(By.xpath("(//img)[3]"))));
        builder = new Actions(driver);
        for(WebElement each : images){
            builder.moveToElement(each).pause(1000).build().perform();
        }
        BrowserUtils.wait(3);
         */
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //builder pattern => you put one method then you can take action
        //builder pattern == chaining methods
        //what is build?
        //if you have multiple actions you have to put build
        //to combine a couple of actions.
        //build() is needed when you have couple of actions
        //build combines the action; perform; starts the action
        //in this example; first we move to one image then second so we used build
        //always end with perform
        //perform does not click, it starts the action, execute the event
        //you can perform click, drag and drop etc
        //actions class has different implementations
        //moveToElement returns instance of action class that's why we can chain them
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        BrowserUtils.wait(3);
        //hover on the first image
        //verify that "name: user1" is displayed
        //hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webElement thant contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        //move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
        //image is visible but text is visible at certain points in this example

        //move to the third image
        actions.moveToElement(img3).perform();
        WebElement imgText3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(imgText3.isDisplayed());
    }


    @Test
    public void JQueryUIMenuTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com/jqueryui/menu");
        //hover on "enabled"
        //hover on "downloads"
        //click on PDF
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf= driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enabled).
                pause(1000).
                moveToElement(downloads).
                pause(1000).
                click(pdf).
                build().perform();
    }


    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        //for cookies
        WebElement cookies = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[2]/div/button"));
        cookies.click();
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        //haha i did clickandhold then movetoelement then release
        actions.clickAndHold(moon).
                pause(2000).
                moveToElement(earth).
                pause(1000).
                release().
                build().perform();

//        actions.dragAndDrop(moon,earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(expected,actual);
    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
