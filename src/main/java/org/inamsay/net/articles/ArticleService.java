package org.inamsay.net.articles;

import jakarta.enterprise.context.ApplicationScoped;
import org.inamsay.net.smartbackoffice.api.model.Article;

@ApplicationScoped
public class ArticleService {

  public Article get(){
    return new Article().name("cola");
  }
}
