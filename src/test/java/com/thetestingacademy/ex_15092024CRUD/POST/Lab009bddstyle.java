package com.thetestingacademy.ex_15092024CRUD.POST;
//WE NEED
//syntax  gherkin (given , when , then )
//non bdd and still gherkin()


//given()
//URL : https://restful-booker.herokuapp.com/auth
//HEADER :
//BASE URi : https://restful-booker.herokuapp.com
//BASE PATH : /auth
//AUTH ,:BASIC , DIGEST , JWT , BEARER TOKEN


//when ()

//PAYLOAD : no yes , json , xml , string
//{
//        "username" : "admin",
//        "password" : "password123"
//        }
//POST REQUEST


//then()
//VERIFICATION
//STATUS CODE : 200
//RESPONSE BODY :
//TIME , HEADERS , COOKIES

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Lab009bddstyle {
    public static void main(String[] args) {
        String payload = "{\"username\" : \"admin\",\n" +
                "                          \"password\" : \"password123\"}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body(payload)
                .when().log().all()
                .post()

                .then().log().all().statusCode(200);
    }
}

