package org.acme.application.mappers;

import org.acme.application.dto.ProdutoDTO.ProdutoDTO;
import org.acme.domain.entities.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface IProdutoMapper {

    ProdutoDTO toDTO(Produto produto);
    Produto toDomain(ProdutoDTO dto);
}
