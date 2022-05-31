package com.bestbuy.productinfo;

import com.bestbuy.Model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPostTest extends TestBase {
    @Test
    public void createProduct() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Alkline Battery");
        productPojo.setType("Alkline Battery");
        productPojo.setPrice(100);
        productPojo.setShipping(0);
        productPojo.setUpc("000444");
        productPojo.setDescription("Long-lasting energy");
        productPojo.setManufacturer("Kodak");
        productPojo.setModel("UC-333");

        Response response = given()
            .header("Content-Type", "application/json")
            .body(productPojo)
            .when()
            .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();

}


}
