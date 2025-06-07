package org.inamsay.net;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
public class CrudService<E> {

  private final EntityManager entityManager;

  public CrudService(EntityManager entityManager) {
    this.entityManager = entityManager;
  }
  public E persit(E entity) {
    entityManager.persist(entity);
    return entity;
  }
}
