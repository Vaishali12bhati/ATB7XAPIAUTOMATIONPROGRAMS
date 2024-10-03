package com.thetestingacademy.ex_14092024.Testng;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab011bddstyle {
    @Test
    public void get(){
        RestAssured.
                given().relaxedHTTPSValidation().
                baseUri("https://api.zippopotam.us").basePath("/IN/560066")
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
