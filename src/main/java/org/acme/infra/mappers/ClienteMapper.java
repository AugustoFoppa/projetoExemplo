package org.acme.infra.mappers;

import org.acme.domain.entities.Cliente;
import org.acme.infra.models.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ClienteMapper {

    Cliente toDomain(ClienteEntity clienteEntity);

    ClienteEntity toEntity(Cliente cliente);
}
