package org.inamsay.net.tables;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.inamsay.net.smartbackoffice.api.TablesApi;
import org.inamsay.net.smartbackoffice.api.model.ApiTable;

import java.math.BigDecimal;

public class TablesResource implements TablesApi {

  private final TablesService tablesService;

  @Inject
  public TablesResource(TablesService tablesService) {
    this.tablesService = tablesService;
  }

  @Override
  public Response createTable(ApiTable apitable) {

    final Table table = new Table();
    table.setName(apitable.getName());
    table.setSeatCount(apitable.getSeatCount());
    table.setActive(apitable.getActive());

    final Table persistedTable = tablesService.persit(table);

    return Response.created(
            java.net.URI.create("tables/" + persistedTable.getId())
    ).build();
    /*
    return Response.created(
            java.net.URI.create("todo")
    ).build();*/
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
  public Response updateTable(BigDecimal tableId, ApiTable table) {
    return Response.ok().build();
  }
}
