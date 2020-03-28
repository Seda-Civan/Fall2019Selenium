package com.automation.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
     * pause test for some time
     * @param seconds
     */
    public static void wait(int seconds){

        try {
            Thread.sleep(1000* seconds);
        } catch (InterruptedException e) {
            //whole thread of classes that we invoked
            //it shows where problem occurred
            //its a message with entire history
            //where exception occurred and what caused exception
            //printStackTrace() :
            // it's a message in console showing the entire history of what exceptions occurred
            // and what classes were involved
            e.printStackTrace();
        }

    }

    //to collect text and  to be able to compare as expected
    //we did an example in day11 WebTable class//so the purpose of the method in BrowserUtils is
    // to convert the List of Collections to WebElement in order to use the Assert method?
    //We created list of WebElement in our test method. But in assert method we need to compare two list of Strings.
    //Browser utils convert our list of WebElement to list of String. To make life easier. This is what I understand :))
    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textValues = new ArrayList<>();
        for(WebElement element : elements){
            textValues.add(element.getText());
        }
        return textValues;
    }
}
