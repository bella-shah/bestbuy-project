package com.bestbuy.servicesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesDeleteTest extends TestBase {
    @Test
    public void deleteAllServicesInfo() {
        Response response = given()
                .basePath("/services")
                .pathParam("id",31)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}

