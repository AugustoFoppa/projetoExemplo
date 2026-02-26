package org.acme.infra.mappers;

import org.acme.domain.entities.ItemPedido;
import org.acme.domain.entities.Pedido;
import org.acme.domain.entities.Produto;
import org.acme.infra.models.ItemPedidoEntity;
import org.acme.infra.models.PedidoEntity;
import org.acme.infra.models.ProdutoEntity;

import java.util.Objects;

public class ItemPedidoEntityMapper {

    public static ItemPedido toDomain(ItemPedidoEntity e) {
        Objects.requireNonNull(e, "ItemPedidoEntity nao pode ser null para conversao.");

        Produto produto = null;
        if(e.getProdutoEntity() != null) {
            produto = ProdutoEntityMapper.toDomain(e.getProdutoEntity());
        }

        Long pedidoID = null;
        if(e.getPedidoEntity() != null) {
            pedidoID = e.getPedidoEntity().getId();
        }

        return new ItemPedido(e.getId(), produto, pedidoID, e.getQuantidade(), e.getPrecoUnitario());
    }

    public static ItemPedidoEntity toEntity(ItemPedido e) {
        Objects.requireNonNull(e, "ItemPedido nao pode ser null para conversao.");

        ProdutoEntity produtoEntity = null;
        if(e.getProduto() != null) {
            produtoEntity = ProdutoEntityMapper.toEntity(e.getProduto());
        }

        PedidoEntity pedidoEntity = null;
        if(e.getPedido() != null) {
            pedidoEntity = PedidoEntityMapper.toEntity(e.getPedido());
        }

        if(e.getPedidoID() != null && pedidoEntity == null) {
            pedidoEntity = new PedidoEntity();
            pedidoEntity.setId(e.getPedidoID());
        }

        return new ItemPedidoEntity(e.getId(), produtoEntity, pedidoEntity, e.getQuantidade(), e.getPrecoUnitario());
    }
}
