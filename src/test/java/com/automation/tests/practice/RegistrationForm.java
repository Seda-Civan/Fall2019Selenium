package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String url = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    //p tag name of success message
   // private String firstNameLocator = "firstname"; //we can do this or below option
    //you can either store with By or String
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");

    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    private By cPlusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    //private By cPlusBy = By.cssSelector("input[value=‘cplusplus’]"); same above
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void test1(){
        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("white");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@gmail.com");
        driver.findElement(passwordBy).sendKeys("123456789");
        driver.findElement(phoneBy).sendKeys("213-123-5896");

        driver.findElement(femaleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("05/23/1999");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(5);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual,expected);

        /*
        Alternative would be if you want to check if SIGN UP button is clickable, with negative test

        driver.findElement(By.id("wooden_spoon")).click();
        boolean clickable = driver.findElement(By.id("wooden_spoon")).isEnabled();
        Assert.assertTrue(false==clickable);
         */
    }


    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        //we are looking for specific text we care about visibility of this text after entering one character
        WebElement warningMessage =
                driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @Test
    public void verifyAlphabeticLettersOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warningMessage =
                driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }
    /*
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private WebElement successMessage = driver.findElement(By.xpath("//p"));
    private WebElement firstNameElement = driver.findElement(By.name("firstname"));
    private WebElement lastNameElement = driver.findElement(By.name("lastname"));
    private WebElement userNameElement = driver.findElement(By.name("username"));
    private WebElement emailElement = driver.findElement(By.name("email"));
    private WebElement passwordElement = driver.findElement(By.name("password"));
    private WebElement phoneElement = driver.findElement(By.name("phone"));
    private WebElement genderMaleElement = driver.findElement(By.cssSelector("input[value='male']"));
    private WebElement genderfemaleElement = driver.findElement(By.cssSelector("input[value='female']"));
    private WebElement genderOtherElement = driver.findElement(By.cssSelector("input[value='other']"));
    private WebElement birthdayElement = driver.findElement(By.name("birthday"));
    private Select departmentSelect = new Select(driver.findElement(By.className("department")));
    private Select job_titleSelect = new Select(driver.findElement(By.className("job_title")));
    private WebElement progLangCPlusElement = driver.findElement(By.id("inlineCheckbox1"));
    private WebElement progLangJavaElement = driver.findElement(By.id("inlineCheckbox2"));
    private WebElement progLangJsElement = driver.findElement(By.id("inlineCheckbox3"));
    private WebElement submitBtnElement = driver.findElement(By.id("wooden_spoon"));
     */

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
