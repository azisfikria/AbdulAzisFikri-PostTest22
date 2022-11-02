package com.juaracoding.abdulazisposttestduadua;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetSingle {
    String Getsingle = "https://mern-backend-8881.herokuapp.com/products/62e20d24f0e24546b900e043/";


    @Test
    public void testStatusCode() {
        Response response = RestAssured.get(Getsingle);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int actual = response.getStatusCode();
        Assert.assertEquals(actual, 200);
    }
    @Test
    public void testValidasiGetSingle() {
        given()
                .get(Getsingle)
                .then()
                .statusCode(200)
                .body("name", equalTo("Bootcamp Juli 2022"))
                .body("category", equalTo("Katalon"))
                .body("price", equalTo(2500));
    }
}
