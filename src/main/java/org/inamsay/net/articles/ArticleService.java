package org.inamsay.net.articles;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.inamsay.net.CrudService;


@ApplicationScoped
public class ArticleService extends CrudService<Article> {

  //public Article get(){ return new Article().name("cola");  }

  public ArticleService() {
    super(null);
  }

  @Inject
  public ArticleService(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  protected Class<Article> getEntityClass() {
    return Article.class;
  }
}
