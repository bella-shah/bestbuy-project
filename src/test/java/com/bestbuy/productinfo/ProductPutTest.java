package com.bestbuy.productinfo;

import com.bestbuy.Model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPutTest extends TestBase {
    @Test
    public void createProduct() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(" Zinc Battery");
        productPojo.setType("Battery2");
        productPojo.setPrice(20);
        productPojo.setShipping(10);
        productPojo.setUpc("000444");
        productPojo.setDescription("Long-lasting energy powerful");
        productPojo.setManufacturer("Duracell");
        productPojo.setModel("UC-4444");

        Response response = given()
                .pathParam("id", 9999679)
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .put("/9999679");
        response.then().statusCode(200);
        response.prettyPrint();
        //9999679
    }
}
