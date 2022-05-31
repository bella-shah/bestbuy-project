package com.bestbuy.productinfo;

import com.bestbuy.Model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPatchTest extends TestBase {


        @Test
        public void updateProductWithPatch(){
            ProductPojo productPojo = new ProductPojo();
            productPojo.setName("Zinc Battery");
            productPojo.setType("Fast Rechargeable");
            productPojo.setPrice(55);
            productPojo.setShipping(11);



            Response response = given()
                    .header("Content-Type", "application/json")
                    .pathParam("id", 9999679)
                    .body(productPojo)
                    .when()
                    .patch("/{id}");
            response.then().statusCode(200);
            response.prettyPrint();

        }

    }


