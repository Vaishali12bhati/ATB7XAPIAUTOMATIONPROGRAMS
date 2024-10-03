package com.thetestingacademy.ex_14092024.Testng;
//enablefalse means skit that test case
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab023enablefalse {
    @Test
    public  void test1(){
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void test2(){
        Assert.assertTrue(false);

    }
    @Test
    public void test3(){
        Assert.assertTrue(true);

    }
}
