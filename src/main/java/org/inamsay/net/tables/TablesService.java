package org.inamsay.net.tables;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.inamsay.net.CrudService;
import org.inamsay.net.smartbackoffice.api.model.ApiTable;

@ApplicationScoped
public class TablesService extends CrudService<Table> {


  public TablesService() {
    //just for CDI requirements
    super(null);
  }

  @Inject
  public TablesService(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  protected Class<Table> getEntityClass() {
    return Table.class;
  }

  public ApiTable get(){
    return new ApiTable()
    .name("Berlin ");
  }
}
