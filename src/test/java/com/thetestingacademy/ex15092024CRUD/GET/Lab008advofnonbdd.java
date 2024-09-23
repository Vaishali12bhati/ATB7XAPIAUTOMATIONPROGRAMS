package com.thetestingacademy.ex15092024CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;



public class Lab008advofnonbdd {
    static RequestSpecification r = RestAssured.given();
    public static void main(String[] args) {
        r.baseUri("https://api.zippopotam.us");
        System.out.println("testcase number 1");
        System.out.println(r);
        test1nonbdd();
        System.out.println("testcase number 2");
        test2nonbdd();

    }

    private static void test2nonbdd() {
        r.basePath("/IN/560063");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);


    }

    private static void test1nonbdd() {
        r.basePath("/IN/560066");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }
}

