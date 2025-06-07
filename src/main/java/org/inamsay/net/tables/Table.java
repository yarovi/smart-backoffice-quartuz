package org.inamsay.net.tables;

import jakarta.persistence.Entity;
import org.inamsay.net.BaseEntity;

@Entity
@jakarta.persistence.Table(name = "sbo_tables")
public class Table extends BaseEntity {
  private String name;
  private Integer seatCount;
  private Boolean active;

  public Table() {
    // Default constructor for JPA
  }


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
