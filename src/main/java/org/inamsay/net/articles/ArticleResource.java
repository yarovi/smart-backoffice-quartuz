package org.inamsay.net.articles;


import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ResourceProperties(rolesAllowed={"admin"})
public interface ArticleResource extends PanacheEntityResource<Article,Long> {


  @GET
  @Path("/name")
  @Produces({MediaType.APPLICATION_JSON})
  default Uni<List<PanacheEntityBase>> getArticleByName(@QueryParam("s") String name) {
    return Article.list("#Article.nameContaining", name);
  }
}
