package org.inamsay.net.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.inamsay.net.TablesService;
import org.inamsay.net.smartbackoffice.api.TablesApi;
import org.inamsay.net.smartbackoffice.api.model.Table;

import java.math.BigDecimal;

public class TablesResource implements TablesApi {

  private final TablesService tablesService;

  @Inject
  public TablesResource(TablesService tablesService) {
    this.tablesService = tablesService;
  }

  @Override
  public Response createTable(Table table) {
    return Response.created(
            java.net.URI.create("todo")
    ).build();
  }

  @Override
  public Response deleteTable(BigDecimal tableId) {
    return Response.ok().build();
  }

  @Override
  public Response getTableById(BigDecimal tableId) {
    return Response.ok(tablesService.get()).build();
  }

  @Override
  public Response getTables() {
    return Response.ok(tablesService.get()).build();
  }

  @Override
  public Response updateTable(BigDecimal tableId, Table table) {
    return Response.ok().build();
  }
}
