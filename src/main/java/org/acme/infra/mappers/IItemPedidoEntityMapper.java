package org.acme.infra.mappers;

import org.acme.application.dto.ItemPedidoDTO.ItemPedidoDTO;
import org.acme.domain.entities.ItemPedido;
import org.acme.infra.models.ItemPedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface IItemPedidoEntityMapper {

    ItemPedidoEntity toEntity(ItemPedido itemPedido);
    ItemPedido toDomain(ItemPedidoEntity itemPedidoEntity);
}
