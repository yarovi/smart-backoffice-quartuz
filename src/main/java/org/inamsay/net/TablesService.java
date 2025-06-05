package org.inamsay.net;

import jakarta.enterprise.context.ApplicationScoped;
import org.inamsay.net.smartbackoffice.api.model.Table;

@ApplicationScoped
public class TablesService {

  public Table get(){
    return new Table().name("Berlin ");
  }
}
