package com.automation.utilities;

public class BrowserUtils {

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
}
