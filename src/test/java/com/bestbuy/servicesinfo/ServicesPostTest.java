package com.bestbuy.servicesinfo;

import com.bestbuy.Model.ServicesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesPostTest extends TestBase {
    @Test
    public void createServicesTest() {
        ServicesPojo servicesPojo = new ServicesPojo();

        servicesPojo.setName("Bella");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post("/services");
        response.then().statusCode(201);
        response.prettyPrint();

    }


    }





