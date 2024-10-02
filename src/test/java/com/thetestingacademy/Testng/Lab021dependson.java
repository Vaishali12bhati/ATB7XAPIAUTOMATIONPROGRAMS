package com.thetestingacademy.Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab021dependson {


    @Test
    public void serverstart()
    {
        System.out.println("first server starting ");
    }
    @Test(dependsOnMethods = "serverstart")
    public void login(){
        System.out.println("login possible only server start");
    }
    @Test(dependsOnMethods = "login")
    public void logout(){
        System.out.println("the login after logout works");
        Assert.assertTrue(false);
    }
}
