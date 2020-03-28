package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
    public void test(){

        ///Users/sedacivan/IdeaProjects/Fall2019Selenium/pom.xml
        //System.getProperty("user.dir") + "/pom.xml"
        System.out.println(System.getProperty("user.dir"));
        //properties like a map
        //key - value pair
        // /Users/sedacivan/IdeaProjects/Fall2019Selenium gives this path
        System.out.println(System.getProperty("os.name"));
        //gives operator system - to specify path of some test data
        //you have test data if you need to commit this project to github someone will get they have to
        //you provide path of the project they can take it and use it
        //when you load file to somewhere, in every system location is different but returns most accurate system
        //to make thepath flexible - it can work with every system
        System.out.println(System.getProperty("user.home"));
        //flexible path to downloads folder
        //System.getProperty("user.home") + "/Downloads" =>
        //works for everyone
        String pathToDownloads = System.getProperty("user.home") + "/Downloads";
        System.out.println(pathToDownloads);
        //how to check if file is downloaded ?

        System.out.println(System.getProperty("os.arch"));
        //cpu architecture  -
        //where to get properties ?
        //from oracle we can get list of system properties

        //when you build your framework classses inside you create tests..
        //more we work on automation more we have code
        //we have to organize codes
        //what if you have 5000 tests? it is hard to manage/update them
        //one centrl point of configuration
        //how to say that ; we are testing on test environment now stage environment
        //you need one url, do not want to update url on evey class, test
        //you wanna have a place to control panel
        //where you can specify url, connection types, credentials...
        //organize in one place - defne everything so those changes will apply all at once
        //what people use to define?
        //people use own custom properties
        //plain text file has extension .properties
        //most important info about project => every test will get from configuration.properties
        //how do we use ?
        //put parameterName = value (key=value)
        //browser properties => all our test will get browser type from there
        //we will set up driver only once
        //key should be unique => browser
        //value can be different => chrome
        //configuration.properties => control panel
        //update and maintenance => we will do it from here
        //how we read that properties ? => class in java properties we will use that class to load it
        //ConfigurationReader class


    }









   /*
    Java maintains a set of system properties for its operations.
     Each java system property is a key-value (String-String) pair such as “java.version”=“1.7.0_09".
     You can retrieve all the system properties via System.getProperties()
     or you can also retrieve individual property via System.getProperty(key).
    */
}
/*
design pattern

best coding practices help to resolve design
if you need to design some kind of program => you have lego you know how to use blocks seperately, do not iknow how to put together
developer needs to build some code that will help to connect, old new program developer need to connect properly
can write everythin in same class but would be hard to reuse
this best practices = guidelines = blue prints
you know how to create getter setter etc.. need to know how to build them together
3 main categories :
creational  ==== singleton
we ensure that for entire project we have only one instance class
when why we use it ?
we can create webdriver object in one place. every single test will use one particular web driver object
we can access tthat webdriver object in any places that our framework

create private static object     -    make constructor private    -    public getter
make static same for everyone       no one can not create object since constructor is private
make private no one can change

we want to make sure everywhere we use same webdriver object
singleton driver = makes more easier

structral










 */