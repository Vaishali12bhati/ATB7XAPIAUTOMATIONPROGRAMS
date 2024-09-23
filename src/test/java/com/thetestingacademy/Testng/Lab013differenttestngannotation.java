package com.thetestingacademy.Testng;

import org.testng.annotations.*;

public class Lab013differenttestngannotation {
    @BeforeSuite
    void demo(){
        System.out.println("print this before running a suite");

    }
    @BeforeClass
    void demo1(){
        System.out.println("print this before running the class");
    }
    @BeforeMethod
    void demo2(){
        System.out.println("print this before running the method");
    }
    @BeforeTest
    void demo3(){

        System.out.println("print this before running the Test");
    }
    @Test
    void demo4(){
        System.out.println("print run the test ");
    }
    @AfterSuite
    void demo5(){
        System.out.println("print this after running the suite");
    }
    @AfterClass
    void demo6(){
        System.out.println("print this after running the class");
    }
    @AfterMethod
    void demo7(){
        System.out.println("print this after running the method");
    }
    @AfterClass
    void demo8(){
        System.out.println("print this after running the class");
    }
    @AfterTest
    void demo9(){
        System.out.println("print this after running the test");
    }
    }
