package com.thetestingacademy.ex_21092024.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Lab031AssertJ {
    static RequestSpecification requestSpecification;
    static ValidatableResponse validatableResponse;
    static Response response;
    Integer bookingId;
    @Test
    public void assertJ()
    {
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
        bookingId = response.jsonPath().getInt("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        System.out.println(bookingId);
        //assertJ
        assertThat(bookingId).isNotZero().isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Vaishali").isNotNull().isAlphabetic().asString();



    }
}
