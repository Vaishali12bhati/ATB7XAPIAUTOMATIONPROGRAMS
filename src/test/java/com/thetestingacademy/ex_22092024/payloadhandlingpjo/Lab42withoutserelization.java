package com.thetestingacademy.ex_22092024.payloadhandlingpjo;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab42withoutserelization {

    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;
    @Description("TC1 -  VERIFY THE CREATE BOOKING WITH VALID PAYLOAD")
    @Test
    public  void withser(){
        String BASE_URL= "https://restful-booker.herokuapp.com/";
        String BASE_PATH = "/booking/";
        String firstName = "vaishali";
                String payload = "{\n" +
                "    \"firstname\" : \""+firstName +
                "    \"lastname\" : \"bhati\",\n" +
                "    \"totalprice\" : 1200,\n" +
                "    \"depositpaid\" : true,\n" +"}";
                //given
                r.baseUri(BASE_PATH);
                r.basePath(BASE_PATH);
                r.contentType(ContentType.JSON);
                r.body(payload);
                //response
        response = r.when().log().all().post();
        String ResponseString = response.asString();
        System.out.println(ResponseString);

        //validate
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
