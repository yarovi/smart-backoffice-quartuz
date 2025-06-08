package org.inamsay.net.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.inamsay.net.BaseEntity;

@Entity
@Table(
        uniqueConstraints = {
                @jakarta.persistence.UniqueConstraint(columnNames = {"name"})
        }
)
public class Category extends BaseEntity {

  @NotNull
  private String name;

  @NotNull
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
