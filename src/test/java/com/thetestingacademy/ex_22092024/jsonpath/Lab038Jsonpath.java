package com.thetestingacademy.ex_22092024.jsonpath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

//json path
//get the response in the json string
//make a request >> with the json
//response also come in json string
// so we have to extract the response from json and verify by using assertj,testNG assertion or default rest assure
//how we extract the response
//json path is a query language for json  which will enable you to extract the specific elements from json string
// the response we take to jsonpathfinder nd convert
public class Lab038Jsonpath {
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
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        //when
        response = requestSpecification.when().post();
        System.out.println(response.asString());
        //getvalidation


        //extract the json
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingid = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String lastname = jsonPath.getString("booking.lastname");
        String checkout = jsonPath.getString("booking.bookingdates.checkout");
        System.out.println(bookingid);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(checkout);

        //verification
        assertThat(firstname).isEqualToIgnoringCase("vaishali").isNotNull().isNotEmpty();
        assertThat(bookingid).isNotEmpty().isNotNull();
        assertThat(lastname).isEqualTo("bhati").isNotNull().isNotEmpty();
        assertThat(checkout).isNotEmpty().isNotNull();

    }


}
