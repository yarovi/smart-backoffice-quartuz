package org.inamsay.net.articles;


import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface ArticleResource extends PanacheEntityResource<Article,Long> {


}
