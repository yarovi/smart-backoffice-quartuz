package org.inamsay.net;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity extends PanacheEntityBase {

  @Id
  @SequenceGenerator(name = "entity_seq", sequenceName = "entity_seq")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
