package org.inamsay.net;

import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.inamsay.net.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class CategoriesResourceTest {
/*
  @InjectMocks
  private CategoryService categoryService;
  @BeforeEach
  void setup(){
    PanacheMock.mock(Category.class);

    final Category category = new Category();
    category.setName("Mock");


    Mockito.when(categoryService.findAll()).thenReturn(List.of(category));

  }

  @Test
  void getsListOfCategories(){

    final Response response= given()
            .when().get("/categories")
            .then()
            .statusCode(200)
            .extract().response();

    final JsonPath jsonPath = response.jsonPath();
    Assertions.assertEquals("Mock",jsonPath.getString("[0].name"));

  }*/
}
