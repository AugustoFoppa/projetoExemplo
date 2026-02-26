package org.acme.application.mappers;

import org.acme.application.dto.ClienteDTO.ClienteDTO;
import org.acme.domain.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface IClienteMapper {

    ClienteDTO toDTO(Cliente cliente);
    Cliente toDomain(ClienteDTO dto);
}
