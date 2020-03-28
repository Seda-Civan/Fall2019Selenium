package com.automation.tests.day12;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

    }

    @Test
    public void checkBoxTest(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        for (int i = 0; i < checkBoxes.size(); i++) {
            Assert.assertTrue(checkBoxes.get(i).isSelected());
        }
    }

    /**
     * go to web orders page
     * verify that Steve Johns zip code is 21233
     * Then update his ip code to 20002
     * Then verify that zip code is 20002
     */
    @Test
    public void updateZipCode(){
        WebElement zipCode  = driver.findElement(By.xpath("//*[text()='Steve Johns']/following-sibling::td[7]"));
        Assert.assertEquals(zipCode.getText(),"21233");

        WebElement updateBtn = driver.findElement(By.xpath("//*[text()='Steve Johns']/following-sibling::td[11]"));
        updateBtn.click();

        WebElement zipInputBox = driver.findElement(By.cssSelector("[id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
        zipInputBox.clear();
        zipInputBox.sendKeys("20002");
        WebElement updateBtn2 = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
        updateBtn2.click();

        zipCode = driver.findElement(By.xpath("//*[text()='Steve Johns']/following-sibling::td[7]"));

        Assert.assertEquals(zipCode.getText(),"20002");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
