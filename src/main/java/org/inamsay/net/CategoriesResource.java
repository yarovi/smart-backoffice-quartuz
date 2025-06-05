package org.inamsay.net;

import org.inamsay.net.smartbackoffice.api.CategoriesApi;
import org.inamsay.net.smartbackoffice.api.model.Category;

import java.math.BigDecimal;
import java.util.List;

public class CategoriesResource implements CategoriesApi {
  @Override
  public void createCategory(Category category) {

  }

  @Override
  public void deleteCategory(BigDecimal categoryId) {

  }

  @Override
  public List<Category> getCategories() {
    return List.of(new Category().name("drinks"));
  }

  @Override
  public Category getCategoryById(BigDecimal categoryId) {
    return null;
  }

  @Override
  public void updateCategory(BigDecimal categoryId, Category category) {

  }
}
