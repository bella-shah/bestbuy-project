package com.bestbuy.storeinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresDeleteTest extends TestBase {
    @Test
    public void deleteAllProductInfo() {
        Response response = given()
                .basePath("/stores")
                .pathParam("id",8927)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}


