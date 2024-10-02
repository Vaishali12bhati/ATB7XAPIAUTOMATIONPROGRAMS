package com.thetestingacademy.Testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.transform.Source;

public class Lab017passvalue {
    String Token;
    String Booking_id;
    @BeforeTest
    public  String getToken(){
        Token = "123";
        return Token;
    }
    @BeforeTest
    public  void getTokenAndBookingID(){
        Booking_id = "12233";
    }
    @Test
    public  void testput(){
        System.out.println(Token);
        System.out.println(Booking_id);
    }
}
