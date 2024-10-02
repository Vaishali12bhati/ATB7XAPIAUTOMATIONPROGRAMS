package com.thetestingacademy.Testng;

import org.apache.log.Priority;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class lab019priorotywise {
    @BeforeTest()
    public void getbookingid(){
        System.out.println("5");
    }
    @BeforeTest
    public void gettoken(){
        System.out.println("4");
    }
    @Test(priority = 2)
    public void testcase1(){
        System.out.println("2");
    }
    @Test(priority = 1)
    public  void testcase2(){
        System.out.println("1 ");
    }
    @Test(priority = 3)
    public  void testcase5() {
        System.out.println("3 ");
    }
    @AfterTest
    public  void testcase3(){
        System.out.println("this teh third one ");
    }
}
