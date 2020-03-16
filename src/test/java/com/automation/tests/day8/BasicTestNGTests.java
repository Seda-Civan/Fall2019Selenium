package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

//From big to small, it goes: Suite, Test, Class, Method

    //runs only once before   @BeforeClass  and    @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }

    //RUNS ONLY ONCE IN THE CLASS BEFORE  @BeforeMethod  AND BEFORE ANY TEST
    //regardless of number of tests; it runs only once
    @BeforeClass   //=> appear only once per class
    public void beforeClass(){
        //sth that should be done only once in the class before all tests
        System.out.println("BEFORE CLASS");
    }

    @AfterClass  //=> appear only once per class
    public void afterClass(){
        //sth that should be done only once in the class after all tests
        System.out.println("AFTER CLASS");
    }

    //runs before every test automatically
    //works a a pre-condition or setup
    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }


    //runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }

    @Test
    public void test1(){
        System.out.println("TEST 1");
        String expected = "apple";
        String actual ="apple";
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void test2(){
        System.out.println("TEST 2");
        int num1 = 15;
        int num2 = 10;
        //it calls hard assertion
        //if assertion fails - it stops execution (due to exception)
        Assert.assertTrue(num1>num2);
    }
}
/*
BEFORE CLASS

    BEFORE METHOD
         TEST 1
    AFTER METHOD

    BEFORE METHOD
         TEST 2
    AFTER METHOD

AFTER CLASS

 */