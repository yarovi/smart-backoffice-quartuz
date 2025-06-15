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


}
