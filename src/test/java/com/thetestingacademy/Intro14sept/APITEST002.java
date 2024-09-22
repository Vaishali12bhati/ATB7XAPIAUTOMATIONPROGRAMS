package com.thetestingacademy.Intro14sept;

import io.restassured.RestAssured;

public class APITEST002 {
    public static void main(String[] args) {
        System.out.println("START THE API AUTOMATION ");
        // WE USEF GHERKINS SYNTAX
        //given() : url , headers , body , or payload
        // when () : http methods : get ,post, put , patch,delete
        //then () : verify  the response er == ar
        //example below
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/booking/2").log().all()
                .when()
                 .get()
                .then().log().all()
                .statusCode(200);
    }
}
