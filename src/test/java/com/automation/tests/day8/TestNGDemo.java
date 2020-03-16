package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo {

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }
    @Test(priority = 3)
    public void test1(){
        String word = "java";
        String word2 = "java";
        System.out.println("Test1");
        Assert.assertEquals(word,word2);
    }

    @Ignore
    @Test (priority = 2)
    public void test2(){
        String word = "javascript";
        String word2 = "java";
        System.out.println("Test2");
        Assert.assertEquals(word,word2);

    }


    @Test(priority = 1)
    public void test3(){
        System.out.println("test 3");
        Assert.assertTrue(15>10);
    }


    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
}
