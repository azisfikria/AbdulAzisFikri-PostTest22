package com.juaracoding.abdulazisposttestduadua;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestPut {
    String GetPut = "https://mern-backend-8881.herokuapp.com/products/6358663e2a69305d31d36526";

    @Test
    public void testPutProductId() {
        JSONObject request = new JSONObject();
        request.put("name", "Bootcamp Juli 2022");
        request.put("category", "Katalon");
        request.put("price", 2500);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put(GetPut)
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void testValidasiPut() {
        given()
                .get(GetPut)
                .then()
                .statusCode(200)
                .body("name", equalTo("Bootcamp Juli 2022"))
                .body("category", equalTo("Katalon"))
                .body("price", equalTo(2500));
    }
}
