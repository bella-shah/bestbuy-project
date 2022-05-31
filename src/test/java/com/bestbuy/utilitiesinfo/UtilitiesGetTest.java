package com.bestbuy.utilitiesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UtilitiesGetTest extends TestBase {
    @Test
    public void getAllUtilitiesInfo() {
        Response response = given()
                .when()
                .get("/version");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getAllUtilitiesInfo1() {
        Response response = given()
                .when()
                .get("/healthcheck");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    }




