package com.thetestingacademy.ex_21092024.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab025TestIntergration {
    //create booking
    //create a token
    //create a booking
    //perform put
    //perform put is get by GET request
    //delete request
    static RequestSpecification requestSpecification;
   static ValidatableResponse validatableResponse;
   static Response response;
    String token;
    String bookingId;
@BeforeTest
    public void create_booking_id(){
        String payload = "{\n" +
                "    \"firstname\" : \"Vaishali\",\n" +
                "    \"lastname\" : \"bhati\",\n" +
                "    \"totalprice\" : 1200,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        //given
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        //when
        response = requestSpecification.when().post();

        //getvalidation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);

    }
@BeforeTest
    public void getToken(){
        String payload = "{\"username\" : \"admin\",\n" +
                "                          \"password\" : \"password123\"}";

        //given
        requestSpecification = RestAssured.given();
        requestSpecification.basePath("/auth");
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        //when part
        response = requestSpecification.when().post();

        //then part
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        //extract token
        token = response.jsonPath().getString("token");
        System.out.println(token);


    }

    @Test(priority = 1)
    public void update_booking_id(){
        String payloadput = "{\n" +
                "    \"firstname\" : \"news\",\n" +
                "    \"lastname\" : \"testings\",\n" +
                "    \"totalprice\" : 1112,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2020-01-01\",\n" +
                "        \"checkout\" : \"2020-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        //given
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadput).log().all();

        //when
        response = requestSpecification.when().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }
    @Test(priority = 2)
    public  void verify_update_booking_idgetRequest(){
        System.out.println(bookingId);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId);
        //when
        response = requestSpecification.when().log().all().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }
    @Test(priority = 3)
    public void delete_bookingid(){
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.cookie("token",token);
        response = requestSpecification.when().log().all().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }
    @Test(priority = 4)
    public void verify_delete_bookingidgetrequest(){
        System.out.println(bookingId);

    }

}
