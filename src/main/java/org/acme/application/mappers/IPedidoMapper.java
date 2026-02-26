package org.acme.application.mappers;

import org.acme.application.dto.PedidoDTO.PedidoDTO;
import org.acme.domain.entities.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", uses = { IItemPedidoMapper.class })
public interface IPedidoMapper {

    PedidoDTO toDTO(Pedido pedido);
    Pedido toDomain(PedidoDTO dto);
}
