package org.acme.application.dto.ItemPedidoDTO;

import org.acme.application.dto.PedidoDTO.PedidoDTO;
import org.acme.application.dto.ProdutoDTO.ProdutoDTO;

import java.math.BigDecimal;

public record ItemPedidoDTO(Long id,
                            ProdutoDTO produto,
                            Long pedidoID,
                            BigDecimal quantidade,
                            BigDecimal precoUnitario) {
}
