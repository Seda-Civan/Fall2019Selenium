package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

//ConfigurationReader class ==> we need this class to load and to use configuration file
//to get configuration.properties => call getProperty method
public class ConfigurationReader {
    /*
    whenever you call this class (ConfigurationReader) =>  static block will be executed
    static block is the highest priority in terms of execution order
    order => static block
             instance block
             constructor
     */

    private static Properties configFile;
    //loading process will work/executed only once whenever class will be loaded
    //when we load property file once this block of code will be executed
    //instance block -> will be executed when object will be created
    //static block call anything from that class, code will be executed
    //
    static {
        try {
            //location of properties file
            //to get the path to configuration file
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //FileInputStream takes the file loads into our program
            //get that file as a stream
            //we have some kind of data in our java program, we need to get data as sth java understand
            //stream convert it sth java understand
            //open the door for java files that are outside
            FileInputStream input = new FileInputStream(path);
            //Properties we can load our custom properties that are coming from configuration.properties
            //create object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            //close the input stream
            input.close();
            //incase file not found, FileInputStream throwws exception. fileNotFound checked exception
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     * call this method and provide a key name to get a value. ex: configurationReader.getProperty("browser")
     * This method returns property value from configuration.properties file
     * @param keyName property name
     * @return property value
     */
    //static getter method that returns value of the property
    public static String getProperty(String keyName) {
        //we have only one properties
        //keyname = browser
        return configFile.getProperty(keyName);
    }

}
/*
{ } empty block vs constructor ?
instance block == { } execuete before constructor
static 2. instance block 3. constructor execute
 */


//