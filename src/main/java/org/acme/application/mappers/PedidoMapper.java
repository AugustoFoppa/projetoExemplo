package org.acme.application.mappers;

import org.acme.domain.entities.Cliente;
import org.acme.domain.entities.ItemPedido;
import org.acme.domain.entities.Pedido;
import org.acme.application.dto.ClienteDTO.ClienteDTO;
import org.acme.application.dto.ItemPedidoDTO.ItemPedidoDTO;
import org.acme.application.dto.PedidoDTO.PedidoDTO;

import java.util.List;
import java.util.Objects;

public class PedidoMapper {

    public static PedidoDTO toDTO(Pedido e) {
        Objects.requireNonNull(e, "Pedido nao pode ser null para conversao");

        ClienteDTO clienteDTO = null;
        if(e.getCliente() != null) {
            clienteDTO = ClienteMapper.toDTO(e.getCliente());
        }

        List<ItemPedidoDTO> itemPedidoDTOList = null;
        if(e.getItemPedidoList() != null) {
            itemPedidoDTOList = e.getItemPedidoList().stream().filter(Objects::nonNull).map(ItemPedidoMapper::toDTO).toList();
        }

        return new PedidoDTO(e.getId(), e.getDateTime(), clienteDTO, itemPedidoDTOList);
    }

    public static Pedido toDomain(PedidoDTO dto) {
        Objects.requireNonNull(dto, "PedidoDTO nao pode ser null para conversao");

        Cliente cliente = null;
        if(dto.cliente() != null) {
            cliente = ClienteMapper.toDomain(dto.cliente());
        }

        List<ItemPedido> pedidoList = null;
        if(dto.itemPedidoList() != null) {
            pedidoList = dto.itemPedidoList().stream().filter(Objects::nonNull).map(ItemPedidoMapper::toDomain).toList();
        }

        return new Pedido(dto.id(), dto.dateTime(), cliente, pedidoList);
    }
}
