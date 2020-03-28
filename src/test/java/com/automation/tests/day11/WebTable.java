package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTable {

    /*
    tr => row
    th => coloumn (table header)
    td => table data
    comman practice is to find web table element is => xpath
    //table//tr[1]//td[3]

    syntax is simple, Table 1 -> Row 1 -> Element#3
    //table[@id="table1"]//tbody//tr[1]//td[3]

    //table[1]//tbody//tr[1]//td[3]

    //*[@id='table1']//tr[1]//td[3]

    table header :   //*[@id="table1"]//thead/tr/th

      //*[@id="table1"]//tbody//td  ==>> gives all cells
      but if you specify row   ==>> //*[@id="table1"]//tbody//tr[3]//td  : it goes that exact data

      if we do not specify index => //table[1]//th  finds all th elements, all table headers
     */


    private WebDriver driver;

    @Test
    public void getColumnNames(){
        //th represents table header cells
        List<String> expected = Arrays.asList("Last Name" , "First Name" , "Email" , "Due" , "Web Site" , "Action");
        //below actual column names coming from table
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        //once we collected all table headers; we can get the names
        //just to print
        for(WebElement columnName : columnNames){
            System.out.println(columnName.getText());
        }

        //BrowserUtils.getTextFromWebElements(columnNames) ==>
        // this method takes the text of every single webElement and puts it into collection of strings
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount(){
        ////tbody//tr  - to get all roews from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of this collection,  it automatically equals to number of elements
        //expected result => 4 => number of rows
        //actual result => size of the collection(rows.size())
        Assert.assertEquals(rows.size(), 4);
    }

    /**
     * to get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn() {
        //td[5] - column with links
        //how we can collect all websites
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        //to print the text - we call our custom method from browserUtills class
        System.out.println(BrowserUtils.getTextFromWebElements(links));

        // //how we can collect all emails
        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//tbody//tr//td[3]"));
        for (WebElement email : emails) {
            System.out.println(email.getText());
        }
    }

    //first way :
    //once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
    //td element with email and td element that contains delete => are siblings
    ////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']

    //to make it easier :
    //go back to parent and find link that has text delete
    //td is child of tr
    ////td[text()='fbach@yahoo.com']/..//a[text()='delete']

    //even more simple way :
    //it is more hardcoded! but easiest => you provide index so it s not flexible, if index is change locator will never find it
    //go to find email in the first table go to parent go to second link inside this element
    ////table[1]//td[text()='jsmith@gmail.com']/..//a[2]

    /**
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */
    @Test
    public void deleteRowTest() {
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();

        BrowserUtils.wait(3);

        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount, 3);

        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
        Assert.assertTrue(emails.isEmpty());
    }


    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName = columnNames.get(i).getText();

            //to be able to concat
            //from left to right ; %s => will be replaced with actualColumnName , position%s will be replaced with => i
            System.out.println(String.format("Column name: %s, position%s", actualColumnName, i));


            if(actualColumnName.equals(columnName)){
                //to remember position of that column
                index = i+1;
            }
        }

        Assert.assertEquals(index,3);
    }

    @Test
    public void getSpecificCell(){
        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]" ;

        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(), expected);
    }

    /*
    If you wan’t to add all emails into list, collect all elements whose locator is 3rd element
    @Test
    public void table_test_content(){
        List<WebElement> emails = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody//td[3]"));
        for (WebElement email:emails
             ) {
            System.out.println(email.getText());
        }}*/
    /*
     @Test
    public void tryTable() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/tables");
        List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']//thead//tr//th"));
        List<String> result=headers.stream().map(x->x.getText()).collect(Collectors.toList());
            System.out.println(result);
        }
     */

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");

        ChromeOptions chromeOptions = new ChromeOptions();
        //set it to true to make it work
        chromeOptions.setHeadless(false); //to run browser without GUI, Makes browser invisible
        //it is twice faster because browser does need to render website to get html code
        //headless mode makes execution twice faster
        //it does everything except -> file uploading
        //very common practice
        driver = new ChromeDriver(chromeOptions);

        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

}
