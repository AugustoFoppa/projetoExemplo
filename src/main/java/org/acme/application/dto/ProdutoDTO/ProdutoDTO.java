package org.acme.application.dto.ProdutoDTO;

import java.math.BigDecimal;

public record ProdutoDTO(Long id,
                         String nome,
                         BigDecimal preco,
                         BigDecimal estoque) {
}
