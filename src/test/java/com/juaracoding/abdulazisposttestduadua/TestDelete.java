package com.juaracoding.abdulazisposttestduadua;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class TestDelete {
    String GetDelete = "https://mern-backend-8881.herokuapp.com/products/630502d57207f2c541e470ca";

    @Test
    public void testDeleteProduct() {
        when()
                .delete(GetDelete)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testValidasiDelete() {
        given()
                .get(GetDelete)
                .then()
                .statusCode(200);
    }
}
