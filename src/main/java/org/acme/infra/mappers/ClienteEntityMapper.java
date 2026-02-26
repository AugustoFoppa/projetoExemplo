package org.acme.infra.mappers;

import org.acme.domain.entities.Cliente;
import org.acme.infra.models.ClienteEntity;

import java.util.Objects;

public class ClienteEntityMapper {

    public static Cliente toDomain(ClienteEntity e) {
        Objects.requireNonNull(e, "ClienteEntity nao pode ser null para conversao.");
        return new Cliente(e.getId(), e.getNome(), e.getEmail(), e.getCpf());
    }

    public static ClienteEntity toEntity(Cliente e) {
        Objects.requireNonNull(e, "Cliente nao pode ser null para conversao.");
        return new ClienteEntity(e.getId(), e.getNome(), e.getEmail(), e.getCpf());
    }
}
