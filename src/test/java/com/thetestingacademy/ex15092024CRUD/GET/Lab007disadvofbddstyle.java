package com.thetestingacademy.ex15092024CRUD.GET;

import io.restassured.RestAssured;

//redundancy of code

//WE NEED
//syntax  gherkin (given , when , then )
//non bdd and still gherkin()


//given()
//URL
//HEADER
//BASE URL"https://api.zippopotam.us/"
//BASE PATH : /IN/560066
//AUTH ,:BASIC , DIGEST , JWT , BEARER TOKEN


//when ()

//PAYLOAD : no yes , json , xml , string
//GET REQUEST


//then()
//VERIFICATION
//STATUS CODE
//RESPONSE BODY
//TIME , HEADERS , COOKIES

public class Lab007disadvofbddstyle {
    public static void main(String[] args) {
        System.out.println("test1");
        test1();
        System.out.println("test2");
        test2();


    }



   private static void test1() {
        RestAssured.
                given().log().all().
                baseUri("https://api.zippopotam.us").basePath("/IN/560066")
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);

    }

    private static void test2() {
        RestAssured.
                given().log().all().
                baseUri("https://api.zippopotam.us").basePath("/IN/560063")
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }


}

