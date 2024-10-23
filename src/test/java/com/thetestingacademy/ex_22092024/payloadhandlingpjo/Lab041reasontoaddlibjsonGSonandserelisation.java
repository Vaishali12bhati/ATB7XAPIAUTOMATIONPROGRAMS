package com.thetestingacademy.ex_22092024.payloadhandlingpjo;
//things we are learning
//hashmap payload handling
//use of library jackson and gson:: used to convert hashmap payload to string as restassured doesnt support any kind of map
//serilisation : converting from map to string
//deserilisatiom :: converting form string to hash mapas response should be converted into original form
//using hashmap to maintain the test case better than string payload
//in this we are using gson which is converting the hash map into input string and rest assured supported the input string

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab041reasontoaddlibjsonGSonandserelisation {
    static RequestSpecification requestSpecification;
    static ValidatableResponse validatableResponse;
    static Response response;
    String token;
    String bookingId;
    @Test
    public void Hashmappayload(){
        Map<String, Object> jsonBodyusingmap = new LinkedHashMap<>();
        jsonBodyusingmap.put("firstname","vaishali");
        jsonBodyusingmap.put("lastname","bhati");
        jsonBodyusingmap.put("totalprice",111);
        jsonBodyusingmap.put("depositpaid",true);

        Map<String,Object>bookingdatesMap= new LinkedHashMap<>();
        bookingdatesMap.put("checkin","2018-01-19");
        bookingdatesMap.put("checkout","2018-01-29");
        jsonBodyusingmap.put("bookingdates",bookingdatesMap);
        jsonBodyusingmap.put("additionalnedds","breakfast");

        //given
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyusingmap).log().all();

        //when
        response = requestSpecification.when().post();

        //getvalidation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);

    }
}
