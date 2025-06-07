package org.inamsay.net.categories;

import jakarta.enterprise.context.ApplicationScoped;
import org.inamsay.net.smartbackoffice.api.model.Category;

@ApplicationScoped
public class CategoriesService {

  public Category get(){
    return new Category().name("very fancy drink");
  }
}
