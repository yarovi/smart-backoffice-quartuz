package org.inamsay.net.tables;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.inamsay.net.BaseEntity;

@Entity
@jakarta.persistence.Table(name = "sbo_tables",
        uniqueConstraints = @jakarta.persistence.UniqueConstraint(columnNames = {"name"}))
public class Table extends BaseEntity {
  @NotNull
  private String name;
  @NotNull
  private Integer seatCount;
  @NotNull
  private Boolean active;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSeatCount() {
    return seatCount;
  }

  public void setSeatCount(Integer seatCount) {
    this.seatCount = seatCount;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}
