package com.thetestingacademy.ex_21092024.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

//assertion to verify the response
//assertion is to verify the actual result with the expected result
//theree types of asssertion
//hamcrest (rest assured default )
// TestNG assertion>> hard and soft
//AssertJ assertion
public class Lab027 {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    @Test
    public void update_booking_id() {
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
        requestSpecification.basePath("/booking/" + bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payloadput).log().all();

        //when
        response = requestSpecification.when().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
}

