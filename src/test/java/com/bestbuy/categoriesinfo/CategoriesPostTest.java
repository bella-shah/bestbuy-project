package com.bestbuy.categoriesinfo;

import com.bestbuy.Model.CategoriesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPostTest extends TestBase {
    @Test
    public void createCategories() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Bella");
        categoriesPojo.setId("abcat0020002");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.prettyPrint();
        response.then().statusCode(201);


    }
}