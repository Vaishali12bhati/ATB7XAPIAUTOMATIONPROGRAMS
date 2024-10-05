package com.thetestingacademy.ex_21092024.Assertions.Hamcrestassertion;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

//assertion to verify the response
//assertion is to verify the actual result with the expected result
//theree types of asssertion
//hamcrest (rest assured default )
// we dont use as its difficult for completx

public class Lab028hamcrest {

    static RequestSpecification requestSpecification;
    static ValidatableResponse validatableResponse;
    static Response response;
    String token;
    String bookingId;
    @Test
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
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        //when
        response = requestSpecification.when().post();

        //getvalidation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname",Matchers.equalTo("Vaishali"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("bhati"));
        //validatableResponse.body("booking.lastname",Matchers.equalTo("Mavi"));
    }
}

