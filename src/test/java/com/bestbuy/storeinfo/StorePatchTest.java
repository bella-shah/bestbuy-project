package com.bestbuy.storeinfo;

import com.bestbuy.Model.StorePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePatchTest extends TestBase {
    @Test
    public void updateStoreWithPatch() {
        StorePojo storePojo = new StorePojo();
        storePojo.setName("Minnetonka");
        storePojo.setType("BigBox");
        storePojo.setCity("Hopkins");
        storePojo.setZip("55305");


        Response response = given()
                .basePath("/stores")
                .header("Content-Type", "application/json")
                .pathParam("id", 8925)
                .body(storePojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}




