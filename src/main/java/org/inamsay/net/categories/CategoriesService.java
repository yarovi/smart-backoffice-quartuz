package org.inamsay.net.categories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.inamsay.net.CrudService;

@ApplicationScoped
public class CategoriesService extends CrudService<Category> {

  public CategoriesService(){
    super(null);
  }

  @Inject
  public CategoriesService(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  protected Class<Category> getEntityClass() {
    return Category.class;
  }
}
