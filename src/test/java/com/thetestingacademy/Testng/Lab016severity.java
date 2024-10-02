package com.thetestingacademy.Testng;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab016severity {
    @Severity(SeverityLevel.NORMAL)
     @Description("verify that true == true ")
    @Test
    public void TC01(){
        Assert.assertEquals(true,true);

    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify that true != true ")
    @Test
    public void TC2()
    {
        Assert.assertEquals(true,false);

    }
}
