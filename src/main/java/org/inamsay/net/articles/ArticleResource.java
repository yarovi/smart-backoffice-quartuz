package org.inamsay.net.articles;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.inamsay.net.categories.CategoriesService;
import org.inamsay.net.categories.Category;
import org.inamsay.net.smartbackoffice.api.ArticlesApi;
import org.inamsay.net.smartbackoffice.api.model.ApiArticle;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class ArticleResource implements ArticlesApi {

  private final ArticleService articleService;
  private final CategoriesService categoriesService;
  private final ArticleMapper articleMapper;

  @Inject
  public ArticleResource(ArticleService articleService, CategoriesService categoriesService, ArticleMapper articleMapper) {
    this.articleService = articleService;
    this.categoriesService = categoriesService;
    this.articleMapper = articleMapper;
  }

  @Override
  public Response createArticle(@QueryParam("categoryId") @NotNull Long xCategory,@Valid @NotNull ApiArticle apiArticle) {

    final Optional<Category> category = categoriesService.getById(xCategory);
    if (category.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    final Article article = new Article();
    articleMapper.mapToArticle(apiArticle, article);
    article.setCategory(category.get());
    final Article persistedArticle = articleService.persit(article);
    return Response.
            created(URI.create("/articles/" + persistedArticle.getId())
            )
            .build();
  }

  @Override
  public Response deleteArticle(Long articleId) {
    final Optional<Article> article = articleService.getById(articleId);
    if (article.isEmpty())
      return Response.status(Response.Status.NOT_FOUND).build();
    return Response.ok().build();

  }

  @Override
  public Response getArticleById(Long articleId) {

    final Optional<Article> article = articleService.getById(articleId);
    if (article.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(articleMapper.mapToApiArticle(article.get())).build();


  }

  @Override
  public Response getArticles() {
    final List<Article> article = articleService.listAll();

    return Response.ok(article.stream()
                    .map(articleMapper::mapToApiArticle)
                    .toList())
            .build();

  }

  @Override
  public Response updateArticle(@PathParam("articleId") Long articleId, @Valid ApiArticle apiArticle) {
    final Optional<Article> existingArticle = articleService.getById(articleId);
    if (existingArticle.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    final Article article = existingArticle.get();
    articleMapper.mapToArticle(apiArticle, article);
    articleService.update(article);
    return Response.ok().build();
  }
}
