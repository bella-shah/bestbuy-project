package com.bestbuy.categoriesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesDeleteTest extends TestBase {
    @Test
    public void deleteAllCategoriesInfo() {
        Response response = given()
                .pathParam("id", "abcat0020002")
                .when()
                .delete("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }
}