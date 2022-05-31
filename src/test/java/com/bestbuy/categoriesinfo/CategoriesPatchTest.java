package com.bestbuy.categoriesinfo;

import com.bestbuy.Model.CategoriesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPatchTest extends TestBase {
    @Test
    public void updateCategoriesWithPatch() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Bella");
        categoriesPojo.setId("abcat0020002");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParams("id","abcat0020002")
                .body(categoriesPojo)
                .when()
                .patch("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

    }
    }
