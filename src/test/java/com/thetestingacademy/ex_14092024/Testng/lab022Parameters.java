package com.thetestingacademy.ex_14092024.Testng;
//parameter is wehen we giving the values for parameter
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class lab022Parameters {
    @Parameters("browser")
    @Test
    void demo(String value){
        System.out.println("browser is "+value);
    }
}
