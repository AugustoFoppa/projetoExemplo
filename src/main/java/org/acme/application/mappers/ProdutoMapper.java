package org.acme.application.mappers;

import org.acme.domain.entities.Produto;
import org.acme.application.dto.ProdutoDTO.ProdutoDTO;

import java.util.Objects;

public class ProdutoMapper {

    public static ProdutoDTO toDTO(Produto e) {
        Objects.requireNonNull(e, "Produto nao pode ser null para conversao");
        return new ProdutoDTO(e.getId(), e.getNome(), e.getPreco(), e.getEstoque());
    }

    public static Produto toDomain(ProdutoDTO dto) {
        Objects.requireNonNull(dto, "ProdutoDTO nao pode ser null para conversao");
        return new Produto(dto.id(), dto.nome(), dto.preco(), dto.estoque());
    }
}
