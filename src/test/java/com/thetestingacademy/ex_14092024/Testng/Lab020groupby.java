package com.thetestingacademy.ex_14092024.Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab020groupby {
    @Test(groups = {"sanity","qa"})
    public void run_Sanityrun(){
        System.out.println("run sanity");
        System.out.println("qa");
        Assert.assertTrue(false);

    }
    @Test(groups = {"qa","regression","prepod"})
    public void run_regression(){
        System.out.println("run  regression");
        Assert.assertTrue(false);
    }
    @Test(groups = {"dev"})
    public void run_smoke(){
        System.out.println("run smoke");
        Assert.assertTrue(false);
    }
}
