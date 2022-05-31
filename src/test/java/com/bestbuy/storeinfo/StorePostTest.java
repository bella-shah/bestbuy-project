package com.bestbuy.storeinfo;

import com.bestbuy.Model.StorePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePostTest extends TestBase {
    @Test
    public void createStore() {
        StorePojo storePojo = new StorePojo();

        storePojo.setName("Minnetonka");
        storePojo.setType("BigBox");
        storePojo.setAddress("=13513 Ridgedale Dr");
        storePojo.setAddress2("string");
        storePojo.setCity("Hopkins");
        storePojo.setState("MN");
        storePojo.setZip("55305");
        storePojo.setLat(0);
        storePojo.setLng(0);
        storePojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");


        Response response = given()
                .header("Content-Type", "application/json")
                .body(storePojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();

    }
     //id 8925
}

