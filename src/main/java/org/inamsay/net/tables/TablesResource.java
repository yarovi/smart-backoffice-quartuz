package org.inamsay.net.tables;


import jakarta.inject.Inject;
import jakarta.validation.Valid;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.inamsay.net.smartbackoffice.api.TablesApi;
import org.inamsay.net.smartbackoffice.api.model.ApiTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;
import java.util.Optional;


public class TablesResource implements TablesApi {

  Logger logger = LoggerFactory.getLogger(TablesResource.class);

  private final TablesService tablesService;

  private final TableMapper tableMapper;

  @Inject
  public TablesResource(TablesService tablesService, TableMapper tableMapper) {
    this.tablesService = tablesService;
    this.tableMapper = tableMapper;
  }

  @Override
  public Response createTable( ApiTable apiTable) {
    final Table table= new Table();
    tableMapper.mapToTable(apiTable, table);
    final Table persistedTable = tablesService.persit(table);
    logger.info("Table created with ID: {}", persistedTable.getName());
    return Response.created(
            URI.create("tables/" + persistedTable.getId())
    ).build();
  }

  @Override
  public Response deleteTable(@PathParam("tableId") Long tableId) {
    final Optional<Table> table = tablesService.deleteById(tableId);
    if (table.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.noContent().build();
  }

  @Override
  public Response getTableById(@PathParam("tableId")Long tableId) {
    final Optional<Table> table = tablesService.getById(tableId);
    if (table.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(tableMapper.mapToApiTable(table.get())).build();
  }

  @Override
  public Response getTables() {
    final List<Table> tables = tablesService.listAll();

    return Response.ok(
            tables.stream()
                    .map(tableMapper::mapToApiTable)
                    .toList()
    ).build();
  }

  @Override
  public Response updateTable(@PathParam("tableId") Long tableId,@Valid ApiTable apiTable) {
    final Optional<Table> existingTable = tablesService.getById(tableId);
    if (existingTable.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    final Table updatedTable = existingTable.get();
    tableMapper.mapToTable(apiTable, updatedTable);

    tablesService.update(updatedTable);

    return Response.ok().build();
  }
}
