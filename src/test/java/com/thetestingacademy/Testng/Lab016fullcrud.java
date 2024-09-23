package com.thetestingacademy.Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab016fullcrud {

    @Test
    public void TC01(){
        Assert.assertEquals(true,true);

    }
    @Test
    public void TC2()
    {
        Assert.assertEquals(true,false);

    }
}
