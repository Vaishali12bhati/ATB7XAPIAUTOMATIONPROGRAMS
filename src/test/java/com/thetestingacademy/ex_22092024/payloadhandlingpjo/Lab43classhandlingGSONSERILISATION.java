package com.thetestingacademy.ex_22092024.payloadhandlingpjo;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


//for converting into class
//rule
//1{} class, whatever the keys we see are the name of data type
//2. {} further we see this its another class
//3. keys are real instance variable
//class booking {
//String firstName

public class Lab43classhandlingGSONSERILISATION {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    //class pojo
    // baseuri :  https://restful-booker.herokuapp.com/
    //basepath : booking/2684
    //booking id 2684
    //payload = {
    //    "firstname" : "Jim",
    //    "lastname" : "Brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}
    //post
    //put request
    // cookie : token eecee6a7036cd1
    //non
//    RequestSpecification r = RestAssured.given();
//    Response response;
//    ValidatableResponse validatableResponse;
    @Description("TC1 -  VERIFY THE CREATE BOOKING WITH VALID PAYLOAD")
    @Test
    public void gsonserilizationpostpositive() {
        booking booking = new booking();
        booking.setFirstname("vaishali");
        booking.setLastname("bhati");
        booking.setTotalprice(5647);
        booking.setDepositpaid(true);

        Lab043bookingdates bookingdates = new Lab043bookingdates();
        bookingdates.setCheckin("10/3/2024");
        bookingdates.setCheckout("11/10/2024");


        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("breakfast");
        System.out.println(booking);//object we are printing
        //CONVERTING OBJECT TO STRING //serilisation

        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);

        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;
        RequestSpecification r = RestAssured.given();
        
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        //given

        //response
        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonStringpayload);
        response = r.when().log().all().post();
        String ResponseString = response.asString();
        System.out.println(ResponseString);

        //validate
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        DesBookingResponse bookingResponse = gson.fromJson(ResponseString,DesBookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBookingc().getLastname());

    }}
//now w e parse the request //deserlization



