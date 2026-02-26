package org.acme.infra.mappers;

import org.acme.domain.entities.Cliente;
import org.acme.domain.entities.ItemPedido;
import org.acme.domain.entities.Pedido;
import org.acme.infra.models.ClienteEntity;
import org.acme.infra.models.ItemPedidoEntity;
import org.acme.infra.models.PedidoEntity;

import java.util.List;
import java.util.Objects;

public class PedidoEntityMapper {

    public static Pedido toDomain(PedidoEntity e) {
        Objects.requireNonNull(e, "PedidoEntity nao pode ser null para conversao.");

        Cliente cliente = null;
        if(e.getClienteEntity() != null) {
            cliente = ClienteEntityMapper.toDomain(e.getClienteEntity());
        }

        List<ItemPedido> pedidoList = null;
        if(e.getItemPedidoEntityList() != null) {
            pedidoList = e.getItemPedidoEntityList().stream().filter(Objects::nonNull).map(ItemPedidoEntityMapper::toDomain).toList();
        }

        return new Pedido(e.getId(), e.getDateTime(), cliente, pedidoList);
    }

    public static PedidoEntity toEntity(Pedido e) {
        Objects.requireNonNull(e, "Pedido nao pode ser null para conversao.");

        ClienteEntity clienteEntity = null;
        if(e.getCliente() != null) {
            clienteEntity = ClienteEntityMapper.toEntity(e.getCliente());
        }

        List<ItemPedidoEntity> itemPedidoEntityList = null;
        if(e.getItemPedidoList() != null) {
            itemPedidoEntityList = e.getItemPedidoList().stream().filter(Objects::nonNull).map(ItemPedidoEntityMapper::toEntity).toList();
        }

        return new PedidoEntity(e.getId(), e.getDateTime(), clienteEntity, itemPedidoEntityList);
    }
}
