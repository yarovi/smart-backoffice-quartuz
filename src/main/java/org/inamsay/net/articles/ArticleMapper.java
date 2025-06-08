package org.inamsay.net.articles;

import org.inamsay.net.smartbackoffice.api.model.ApiArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ArticleMapper {

  @Mapping(target="id", ignore=true)
  @Mapping(source="picture",target="pictureBase64")
  @Mapping(target = "category", ignore = true)
  void mapToArticle(ApiArticle apiArticle, @MappingTarget Article article);

  @Mapping(source="pictureBase64", target="picture")
  ApiArticle mapToApiArticle(Article article);
}
