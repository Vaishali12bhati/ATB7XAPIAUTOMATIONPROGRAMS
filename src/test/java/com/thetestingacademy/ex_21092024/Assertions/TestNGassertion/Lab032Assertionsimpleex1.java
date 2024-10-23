package com.thetestingacademy.ex_21092024.Assertions.TestNGassertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab032Assertionsimpleex1 {
    @Test
    public void verifciation(){
        String response = "vaishali";
        Assert.assertEquals("vaishali",response);


    }

}
