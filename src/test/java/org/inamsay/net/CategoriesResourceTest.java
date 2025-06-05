package org.inamsay.net;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
//import static io.restassured.RestAssured.given;

@QuarkusTest
public class CategoriesResourceTest {

  @Test
  void getsListOfCategories(){

    final Response response= given()
            .when().get("/categories")
            .then()
            .statusCode(200)
            .extract().response();

    final JsonPath jsonPath = response.jsonPath();
    Assertions.assertEquals("drinks",jsonPath.getString("[0].name"));

  }
}
