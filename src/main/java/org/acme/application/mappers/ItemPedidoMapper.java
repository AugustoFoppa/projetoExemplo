package org.acme.application.mappers;

import org.acme.application.dto.PedidoDTO.PedidoDTO;
import org.acme.domain.entities.ItemPedido;
import org.acme.domain.entities.Pedido;
import org.acme.domain.entities.Produto;
import org.acme.application.dto.ItemPedidoDTO.ItemPedidoDTO;
import org.acme.application.dto.ProdutoDTO.ProdutoDTO;

import java.util.Objects;

public class ItemPedidoMapper {

    public static ItemPedidoDTO toDTO(ItemPedido e) {
        Objects.requireNonNull(e, "ItemPedido nao pode ser null para conversao.");

        ProdutoDTO produtoDTO = null;
        if(e.getProduto() != null) {
            produtoDTO = ProdutoMapper.toDTO(e.getProduto());
        }

        Long pedidoID = null;
        if(e.getPedidoID() != null) {
            pedidoID = e.getPedidoID();
        }

        return new ItemPedidoDTO(e.getId(), produtoDTO, pedidoID, e.getQuantidade(), e.getPrecoUnitario());
    }

    public static ItemPedido toDomain(ItemPedidoDTO dto) {
        Objects.requireNonNull(dto, "ItemPedidoDTO nao pode ser null para conversao");

        Produto produto = null;
        if(dto.produto() != null) {
            produto = ProdutoMapper.toDomain(dto.produto());
        }

        return new ItemPedido(dto.id(), produto, dto.pedidoID(), dto.quantidade(), dto.precoUnitario());
    }
}
