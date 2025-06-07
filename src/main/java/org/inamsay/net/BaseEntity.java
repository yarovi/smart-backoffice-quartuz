package org.inamsay.net;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {

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
