package com.thetestingacademy.Testng;
//alwaysrun is that this test case will run always
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab024alwaysrun {
    @Test(alwaysRun = true)
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
