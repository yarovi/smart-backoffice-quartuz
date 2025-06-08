package org.inamsay.net.categories;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.inamsay.net.smartbackoffice.api.CategoriesApi;
import org.inamsay.net.smartbackoffice.api.model.ApiCategory;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class CategoriesResource implements CategoriesApi {

  private final CategoriesService categoriesService;

  private final CategoryMapper mapper;

  @Inject
  public CategoriesResource(CategoriesService categoriesService, CategoryMapper mapper) {
    this.categoriesService = categoriesService;
    this.mapper = mapper;
  }

  @Override
  public Response createCategory(ApiCategory apiCategory) {
    final Category category = new Category();
    mapper.mapToCategory(apiCategory, category);
    final Category persistedCategory = categoriesService.persit(category);
    return Response.created(
            URI.create("/categories/" + persistedCategory.getId())).build();

  }

  @Override
  public Response deleteCategory(Long categoryId) {
    final Optional<Category> category = categoriesService.deleteById(categoryId);
    if (category.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok().build();
  }

  @Override
  public Response getCategories() {
    final List<Category> categories = categoriesService.listAll();

    return Response.ok(
            categories.stream()
                    .map(mapper::mapToApiCategory)
                    .toList()
    ).build();
  }

  @Override
  public Response getCategoryById(Long categoryId) {
    final Optional<Category> category = categoriesService.getById(categoryId);
    if (category.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(mapper.mapToApiCategory(category.get())).build();
  }

  @Override
  public Response updateCategory(
          Long categoryId,
          ApiCategory apiCategory
  ) {
    final Optional<Category> existingCategory = categoriesService.getById(categoryId);
    if (existingCategory.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    final Category category = existingCategory.get();
    mapper.mapToCategory(apiCategory, category);
    categoriesService.persit(category);
    return Response.ok().build();
  }
}
