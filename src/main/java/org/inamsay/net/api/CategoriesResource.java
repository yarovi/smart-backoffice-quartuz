package org.inamsay.net.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.inamsay.net.CategoriesService;
import org.inamsay.net.smartbackoffice.api.CategoriesApi;
import org.inamsay.net.smartbackoffice.api.model.Category;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

public class CategoriesResource implements CategoriesApi {

  private final CategoriesService categoriesService;

  @Inject
  public CategoriesResource(CategoriesService categoriesService) {
    this.categoriesService = categoriesService;
  }

  @Override
  public Response createCategory(Category category) {
      return Response.created(
              URI.create("todo")
      ).build();
  }

  @Override
  public Response deleteCategory(BigDecimal categoryId) {
      return Response.ok().build();
  }

  @Override
  public Response getCategories() {
    return Response.ok( List.of(new Category().name("drinks"))).build();
  }

  @Override
  public Response getCategoryById(BigDecimal categoryId) {
    return Response.ok(categoriesService.get()).build();
  }

  @Override
  public Response updateCategory(BigDecimal categoryId, Category category) {
    return Response.ok().build();
  }
}
