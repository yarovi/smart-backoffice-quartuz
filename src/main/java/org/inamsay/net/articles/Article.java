package org.inamsay.net.articles;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.inamsay.net.BaseEntity;
import org.inamsay.net.categories.Category;

import java.math.BigDecimal;

@Entity
@Table(uniqueConstraints = {
    @jakarta.persistence.UniqueConstraint(columnNames = {"name", "category_id"})
})
@NamedQuery(name="Article.byCategory",
    query = "FROM Article  WHERE category.id = :id order by price desc")
/*@NamedQuery(name="Article.nameContaining",
        query = "FROM Article  WHERE name like contac('%',contact(?1,'%'))")*/
public class Article extends BaseEntity {

  @NotNull
  private String name;

  @NotNull
  @Positive
  private BigDecimal price;

  @NotNull
  private String description;

  @NotNull
  private String pictureBase64;

  @ManyToOne(optional = false)
  @JoinColumn(name = "category_id")
  private Category category;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPictureBase64() {
    return pictureBase64;
  }

  public void setPictureBase64(String pictureBase64) {
    this.pictureBase64 = pictureBase64;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
