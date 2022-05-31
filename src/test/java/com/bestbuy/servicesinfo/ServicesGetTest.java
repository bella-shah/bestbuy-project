package com.bestbuy.servicesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ServicesGetTest extends TestBase {
    @Test
    public void getAllServicesInfo() {
        Response response = given()
                .when()
                .get("/services");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleServicesInfo() {
        Response response = given()
                .basePath("/services")
                .pathParam("id", 2)
                .when()
                .get("{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchServicesWithParameter() {

        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("$limit", 1);
        qParams.put("$skip", 1);
        Response response = given()
                .queryParams(qParams)
                .when()
                .get("/services");
        response.prettyPrint();
        response.then().statusCode(200);

    }

}


