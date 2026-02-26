package org.acme.application.mappers;

import org.acme.application.dto.ItemPedidoDTO.ItemPedidoDTO;
import org.acme.domain.entities.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface IItemPedidoMapper {

    ItemPedidoDTO toDTO(ItemPedido itemPedido);
    ItemPedido toDomain(ItemPedidoDTO itemPedidoDTO);
}
