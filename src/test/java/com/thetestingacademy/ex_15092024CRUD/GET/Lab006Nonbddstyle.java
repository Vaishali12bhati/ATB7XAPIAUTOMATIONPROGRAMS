package com.thetestingacademy.ex_15092024CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Lab006Nonbddstyle {
    public static void main(String[] args) {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/560066");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }
}
