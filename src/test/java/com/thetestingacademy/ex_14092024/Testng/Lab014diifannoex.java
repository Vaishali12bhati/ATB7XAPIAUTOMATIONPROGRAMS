package com.thetestingacademy.ex_14092024.Testng;

import org.testng.annotations.*;

public class Lab014diifannoex {
    @BeforeSuite
    void demo(){
        System.out.println("read the data from mysql");

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

        System.out.println("data matrix ,Test case before");
    }
    @Test
    void demo4(){
        System.out.println("print run the test ");
    }
    @AfterSuite
    void demo5(){
        System.out.println("close everything , delete temp file");
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


