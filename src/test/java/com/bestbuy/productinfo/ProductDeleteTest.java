package com.bestbuy.productinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductDeleteTest extends TestBase {
    @Test
    public void deleteAllProductInfo() {
        Response response = given()
                .pathParam("id",43900)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
