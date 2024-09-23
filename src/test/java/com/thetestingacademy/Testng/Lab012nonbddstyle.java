package com.thetestingacademy.Testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab012nonbddstyle {
    static RequestSpecification r = RestAssured.given();
    @Test
    public void post(){
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
