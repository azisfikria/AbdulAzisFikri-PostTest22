package com.juaracoding.abdulazisposttestduadua;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetList {
    String Getlist = "https://mern-backend-8881.herokuapp.com/products";


    @Test(priority =1)
    public void testStatusCodeGetList() {
        Response response = RestAssured.get(Getlist);


        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int actual = response.getStatusCode();
        Assert.assertEquals(actual, 200);
    }


    @Test(priority = 2)
    public void testValidasiGetList() {
        given()
                .get(Getlist)
                .then()
                .statusCode(200)
                .body("_id[1]", equalTo("62e20d61f0e24546b900e047"));
    }
}
