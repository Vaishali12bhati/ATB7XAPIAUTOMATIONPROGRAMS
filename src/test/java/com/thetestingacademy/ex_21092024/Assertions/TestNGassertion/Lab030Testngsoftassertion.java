package com.thetestingacademy.ex_21092024.Assertions.TestNGassertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab030Testngsoftassertion {
    @Test
    public void softassertionexample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("hi pls check");//even though the above test case fail but this line will always executed
        softAssert.assertAll();//this will collect all the report
    }
}
