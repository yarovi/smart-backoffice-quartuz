package org.inamsay.net.tables;

import org.inamsay.net.smartbackoffice.api.model.ApiTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface TableMapper {
  @Mapping(target="id", ignore = true)
  void mapToTable(ApiTable apiTable, @MappingTarget Table table);

  ApiTable mapToApiTable(Table table);
}
