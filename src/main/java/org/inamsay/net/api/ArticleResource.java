package org.inamsay.net.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.inamsay.net.ArticleService;
import org.inamsay.net.smartbackoffice.api.ArticlesApi;
import org.inamsay.net.smartbackoffice.api.model.Article;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

public class ArticleResource implements ArticlesApi {

  private final ArticleService articleService;

  @Inject
  public ArticleResource(ArticleService articleService) {
    this.articleService = articleService;
  }
  @Override
  public Response createArticle(Article article) {
      return Response.created(
              URI.create("todo")
      ).build();
  }

  @Override
  public Response deleteArticle(BigDecimal articleId) {
      return Response.ok().build();
  }

  @Override
  public Response getArticleById(BigDecimal articleId) {
    return Response.ok(articleService.get()).build();
  }

  @Override
  public Response getArticles() {
    return Response.ok( List.of(new Article().name("Exampl1"))).build();
  }

  @Override
  public Response updateArticle(BigDecimal articleId, Article article) {
        return Response.ok().build();
  }
}
