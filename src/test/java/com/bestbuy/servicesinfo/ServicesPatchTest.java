package com.bestbuy.servicesinfo;

import com.bestbuy.Model.ServicesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesPatchTest extends TestBase {
    @Test
    public void updateServicesWithPatch() {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Bella");



        Response response = given()
                .basePath("/services")
                .header("Content-Type", "application/json")
                .pathParam("id", 25)
                .body(servicesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
