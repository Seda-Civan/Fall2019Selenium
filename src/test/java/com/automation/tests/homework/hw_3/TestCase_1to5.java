package com.automation.tests.homework.hw_3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestCase_1to5 {

    private WebDriver driver;
    private String url = "https://practice-cybertekschool.herokuapp.com/";
    private By registrationBy = By.linkText("Registration Form");
    private By dateOfBirthBy = By.name("birthday");
    //private By warningMessageBy = By.xpath("//small[text()=\"The date of birth is not valid\"");
    private  By warningMessageBy = By.cssSelector("[data-bv-validator='date']");

    //private By cplusplusBy = By.xpath("//label[text()='C++']");
    //private By cplusplusBy = By.xpath("//label[contains(text(),'C++')]");
    //private By cplusplusBy = By.xpath("//input[@id=\"inlineCheckbox1\"]/following-sibling::label");
    //private By cplusplusBy = By.cssSelector("[class=\"form-check form-check-inline\"]>label[for=\"inlineCheckbox1\"]");
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.cssSelector("[for=\"inlineCheckbox2\"]");
    private By javaScriptBy = By.cssSelector("[for=\"inlineCheckbox3\"]");

    //private By firstNameBy = By.xpath(" //input[@name=\"firstname\" or @placeholder=\"first name\"]");
    //private By firstNameWarningMessageBy = By.xpath("//small[@class=\"help-block\" and @data-bv-validator=\"stringLength\" and @data-bv-result=\"INVALID\"]");
    private By firstNameBy = By.name("firstname");
    private By firstNameWarningMessageBy = By.xpath("//*[text()='first name must be more than 2 and less than 64 characters long']");

    private By lastNameBy = By.name("lastname");
    private By lastNameWarningMessageBy = By.xpath("//*[text()=\"The last name must be more than 2 and less than 64 characters long\"]");

    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneNumberBY = By.name("phone");
    private By maleBy = By.cssSelector("[value=\"male\"]");
    private By femaleBy = By.cssSelector("[value=\"female\"]");
    private By otherBy = By.xpath("//input[@type=\"radio\" and @value=\"female\"]");
    private  By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By signUpBy = By.id("wooden_spoon");
    private By successMessageBy = By.tagName("p");

    /*
    Test case #1
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    (Step1 and 2 are in setup)
    Step 3. Enter “wrong_dob” into date of birth input box.
    Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
    @Test (description = "Verify that warning message is displayed")
    public void invalidDob(){
        driver.findElement(dateOfBirthBy).sendKeys("wrong_dob");
        BrowserUtils.wait(2);
        WebElement warningMessage = driver.findElement(warningMessageBy);
        assertTrue(warningMessage.isDisplayed());
        BrowserUtils.wait(2);
    }

    /*
    Test case #2
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    (Step1 and 2 are in setup)
    Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */
    @Test (description = "Verify that options for programming languages are displayed")
    public void languageOptions(){
        //verifying with List<WebElement>
//        List<WebElement> allLanguages = driver.findElements(By.className("form-check-label"));
//        for(WebElement language : allLanguages){
//            assertTrue(language.isDisplayed(), "Language options are not displayed");
//        }
        //verifying one by one
        WebElement cplusplus = driver.findElement(cplusplusBy);
        WebElement java = driver.findElement(javaBy);
        WebElement javaScript = driver.findElement(javaScriptBy);

        assertTrue(cplusplus.isDisplayed());
        assertTrue(java.isDisplayed());
        assertTrue(javaScript.isDisplayed());
    }


    /*
    Test case #3
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    (Step1 and 2 are in setup)
    Step 3. Enter only one alphabetic character into first name input box.
    Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
     */
    @Test(description = "Verify that warning message is displayed: ")
    public void invalidFirstName(){
        driver.findElement(firstNameBy).sendKeys("a");
        WebElement warningMessage = driver.findElement(firstNameWarningMessageBy);
        BrowserUtils.wait(2);
        assertTrue(warningMessage.isDisplayed(), "Warning message is not displayed");
    }


    /*
    Test case #4
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    (Step1 and 2 are in setup)
    Step 3. Enter only one alphabetic character into last name input box.
    Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
     */
    @Test(description = "Verify that warning message is displayed: ")
    public void invalidLastName(){
        driver.findElement(lastNameBy).sendKeys("a");
        WebElement warningMessage = driver.findElement(lastNameWarningMessageBy);
        BrowserUtils.wait(2);
        assertTrue(warningMessage.isDisplayed(), "Warning message is not displayed");
    }


    /*
    Test case #5
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    (Step1 and 2 are in setup)
    Step 3. Enter any valid firstName
    Step 4. Enter any valid lastName
    Step 5. Enter any valid userName
    Step 6. Enter any valid password
    Step 7. Enter any valid phoneNumber
    Step 8. Select gender.
    Step 9. Enter any valid dateOfBirth
    Step 10. Select any department.
    Step 11. Enter any job title.
    Step 12. Select java as a programming language.
    Step 13. Click Sign up.
    Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
     */
    @Test(description = " Verify : “You've successfully completed registration!" + "message is displayed")
    public void verifyRegistration(){
        driver.findElement(firstNameBy).sendKeys("James");
        driver.findElement(lastNameBy).sendKeys("Bond");
        driver.findElement(userNameBy).sendKeys("jameyB");
        driver.findElement(emailBy).sendKeys("email@gmail.com");
        driver.findElement(passwordBy).sendKeys("123456789");
        driver.findElement(phoneNumberBY).sendKeys("222-151-8963");
        driver.findElement(femaleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("06/05/1987");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByValue("DE");

        Select jobSelect = new Select(driver.findElement(jobTitleBy));
        jobSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();
        BrowserUtils.wait(4);
        WebElement successMessage = driver.findElement(successMessageBy);
        BrowserUtils.wait(4);
        assertTrue(successMessage.isDisplayed(), "Success message is not displayed");
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        // Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
        driver.get(url);
        //Step 2. Click on “Registration Form”
        driver.findElement(registrationBy).click();
    }

    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
