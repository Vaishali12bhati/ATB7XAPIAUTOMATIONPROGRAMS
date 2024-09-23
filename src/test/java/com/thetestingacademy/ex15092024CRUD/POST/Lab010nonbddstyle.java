package com.thetestingacademy.ex15092024CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Lab010nonbddstyle {
    static RequestSpecification r = RestAssured.given();
    public static void main(String[] args) {
        String payload = "{\"username\" : \"admin\",\n" +
                "                          \"password\" : \"password123\"}";
        r.basePath("/auth");
        r.baseUri("https://restful-booker.herokuapp.com");
        r.contentType(ContentType.JSON);
        r.body(payload);

        //when part
        Response response =  r.when().log().all().post();

        //then part
        ValidatableResponse vr = response.then();
       vr.statusCode(200);

    }
}