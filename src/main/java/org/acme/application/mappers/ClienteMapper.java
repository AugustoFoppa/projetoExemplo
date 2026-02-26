package org.acme.application.mappers;

import org.acme.domain.entities.Cliente;
import org.acme.application.dto.ClienteDTO.ClienteDTO;

import java.util.Objects;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente e) {
        Objects.requireNonNull(e, "Cliente nao pode ser null para conversao.");

        return new ClienteDTO(e.getId(), e.getNome(), e.getEmail(), e.getCpf());
    }

    public static Cliente toDomain(ClienteDTO dto) {
        Objects.requireNonNull(dto, "ClienteDTO nao pode ser null para conversao.");

        return new Cliente(dto.id(), dto.nome(), dto.email(), dto.cpf());
    }
}
