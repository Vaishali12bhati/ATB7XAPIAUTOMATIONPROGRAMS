package com.thetestingacademy.ex_21092024.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

//hard assertion means if the test case assertion fails if will not execute the furtehr one
public class Lab029Testngassertionhard {
    @Test
    public void hardassertion(){
        Assert.assertTrue(true);
        System.out.println("hi check pls ");//above condition fails so this statement will not execute

    }


}
