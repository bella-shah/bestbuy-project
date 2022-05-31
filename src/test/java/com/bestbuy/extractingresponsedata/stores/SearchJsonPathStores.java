package com.bestbuy.extractingresponsedata.stores;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathStores {
   static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    //1. Extract the value of limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }
//2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }
//3. Extract the name of 5th store

    @Test
    public void test003() {
        String fifthStore = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of the store : " + fifthStore);
        System.out.println("------------------End of Test---------------------------");
    }
//4. Extract the names of all the store
    @Test
    public void test004() {
        List <String> allStoreNames = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of the all store  : " + allStoreNames);
        System.out.println("------------------End of Test---------------------------");
    }
//5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> allStoreId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store id  : " + allStoreId);
        System.out.println("------------------End of Test---------------------------");
    }
//6. Print the size of the data list
    @Test
    public void test006() {
        int sizeofData = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of data  : " + sizeofData);
        System.out.println("------------------End of Test---------------------------");
    }
//7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List <HashMap<String, ?>> valueOfStoreStCloud = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of store name : " + valueOfStoreStCloud);
        System.out.println("------------------End of Test---------------------------");
    }
//8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List <String> addressOfRochester = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store  : " + addressOfRochester);
        System.out.println("------------------End of Test---------------------------");
    }
//9. Get all the services of 8th store
    @Test
    public void test009() {
        List <String> servicesOf7ThStore = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of the store: " + servicesOf7ThStore);
        System.out.println("------------------End of Test---------------------------");
    }
//10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List <List<String>> servicesNameWindowsStore = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The StoreServices  : " + servicesNameWindowsStore);
        System.out.println("------------------End of Test---------------------------");
    }
//11. Get all the storeId of all the store
    @Test
    public void test011() {
        List <Integer> storeIdOfAllStores = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the store Id : " + storeIdOfAllStores);
        System.out.println("------------------End of Test---------------------------");
    }
//12. Get id of all the store
    @Test
    public void test012() {
        List <Integer> idOfAllStore = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get id of all the store  : " + idOfAllStore);
        System.out.println("------------------End of Test---------------------------");
    }
//13. Find the store names Where state = ND
    @Test
    public void test013() {
        List <Integer> storeNameStateND = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the store name ND : " + storeNameStateND);
        System.out.println("------------------End of Test---------------------------");
    }
//14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        List <List<Integer>> totalServicesOfStoreRochester = response.extract().path("data.findAll{it.name =='Rochester'}.services.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of services of the store  : " + totalServicesOfStoreRochester.get(0).size());
        System.out.println("------------------End of Test---------------------------");
    }
//15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List <?> createdAtServiceNameWindowsStore = response.extract().path("data.find{it.services}.services.findAll{it.name='Windows Store'}.storeservices.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The creation of the all services name : " + createdAtServiceNameWindowsStore);
        System.out.println("------------------End of Test---------------------------");
    }
//16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List <String> nameOfAllServicesOfFargo = response.extract().path("data.findAll{it.name =='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services store name : " + nameOfAllServicesOfFargo);
        System.out.println("------------------End of Test---------------------------");
    }
//17. Find the zip of all the store
    @Test
    public void test017() {
        List<String> zipOfAllStore = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Zip of all the store  : " + zipOfAllStore);
        System.out.println("------------------End of Test---------------------------");
    }
    //18. Find the zip of store name = Roseville
    @Test
    public void test018() {
        String zip = response.extract().path("data[2].zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of the store name  : "+zip);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List <?> storeServicesOfStoreMagnoliaHomeTheater = response.extract().path("data.find{it.services}.services.findAll{it.name='Magnolia Home Theater'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices details of the services  : " + storeServicesOfStoreMagnoliaHomeTheater);
        System.out.println("------------------End of Test---------------------------");
    }
    //20. Find the lat of all the stores
    @Test
    public void test020() {
        List <?> latOfAllStores = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The lat of the all the stores : " + latOfAllStores);
        System.out.println("------------------End of Test---------------------------");
    }
}


