package com.automation.tests.vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
  //provide setup and clean up part for all our test
  //whenever we inherit this testBAse class we have minimum essential/required setup and clean up
  //what else we can add => actions,  actions class object is generic

    //protected = same package + sub class
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        //whenever you instantiate webDriver (=new className) ;
        //getDriver method will return us driver object comes from driver class
        //call static getDriver method through the classNAme
        //we will know we always calling the same driver
        Driver.getDriver().manage().window().maximize();
        //we can not use implicit and explicit test in same test, will conflict each other
        wait = new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
