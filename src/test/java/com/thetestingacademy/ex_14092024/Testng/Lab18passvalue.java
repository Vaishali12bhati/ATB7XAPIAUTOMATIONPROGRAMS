package com.thetestingacademy.ex_14092024.Testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab18passvalue {
    @BeforeTest

    public void getToken()
    {
        System.out.println("1");
    }
    @BeforeTest
public void getBookingid(){
    System.out.println("2");

}

    @Test
    public void testcase3(){
        System.out.println("3" +
                "");
    }
}

