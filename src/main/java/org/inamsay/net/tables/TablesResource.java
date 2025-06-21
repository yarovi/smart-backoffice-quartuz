package org.inamsay.net.tables;


import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(rolesAllowed={"user"})
public interface TablesResource extends PanacheEntityResource< Table, Long> {



}
