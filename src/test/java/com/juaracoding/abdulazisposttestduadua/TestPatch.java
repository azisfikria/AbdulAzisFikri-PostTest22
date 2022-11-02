package com.juaracoding.abdulazisposttestduadua;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPatch {
    String GetPatch = "https://mern-backend-8881.herokuapp.com/products/62e20d95f0e24546b900e049";

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "Bootcamp Post");
        request.put("category", "Katalon");
        request.put("price", 3000);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://mern-backend-8881.herokuapp.com/products/62e20d95f0e24546b900e049")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void testValidasiPatch() {
        given()
                .get(GetPatch)
                .then()
                .statusCode(200)
                .body("name", equalTo("Bootcamp Post"))
                .body("category", equalTo("Katalon"))
                .body("price", equalTo(3000));
    }
}
