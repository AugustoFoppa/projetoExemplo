package org.acme.infra.mappers;

import org.acme.domain.entities.Produto;
import org.acme.infra.models.ProdutoEntity;

import java.util.Objects;

public class ProdutoEntityMapper {

    public static Produto toDomain(ProdutoEntity e) {
        Objects.requireNonNull(e, "ProdutoEntity nao pode ser null para conversao.");
        return new Produto(e.getId(), e.getNome(), e.getPreco(), e.getEstoque());
    }

    public static ProdutoEntity toEntity(Produto e) {
        Objects.requireNonNull(e, "Produto nao pode ser null para conversao.");
        return new ProdutoEntity(e.getId(), e.getNome(), e.getPreco(), e.getEstoque());
    }
}
