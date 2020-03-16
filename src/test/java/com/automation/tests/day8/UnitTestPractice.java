package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    //so, mainly unit testing is checking if methods are working properly

    public static void main(String[] args) {

        //unit test
        //to check if our method works properly
        //if assertion fails, that means our method doesn't work correctly
        //that means we have fix the method
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        //it is coming from testNG, JUnit also has this class
        //you can compare any data types here
        //this below method equals Assertion
        verifyEquals(expected,actual);

    }

    //test annotation used to create test. Put it on top of the method
    //In this case we don;t use main method and we can create lots of tests
    @Test(description = "Verify if method can reverse a String")
    public void test(){
        String expected ="elpp";
        String actual = reverseString("apple");
        //to verify if expected result is equals to actual
        Assert.assertEquals(actual,expected);

    }

    @Test(description = "Verify if method can reverse a String")
    public void test2(){
        String expected = "rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual,expected);
    }

    public static Boolean verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
            return true;
        }else{
            System.out.println("TEST FAILED!!!");
            System.out.println("Expected : "+ expected);
            System.out.println("Actual = " + actual);
            return false;
        }
    }
    /**
     * This method stands for reversing Strings.
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str){
        String reversed = "";
        for (int i = str.length()-1; i >=0 ; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    /*
     We wrote a method that reverse any String,
     without verifying we can not know our code is working properly or not.
     So we wrote a method to check equality of expected and actual result.
     Then we tested, our unit test has passed, code is working properly.
     so basically, we create unit test ourselves via methods, it's not something provided by tools, correct?
      --YES
      everyone does it for own code. developers => for app code. qa => for our framework
     */
}
