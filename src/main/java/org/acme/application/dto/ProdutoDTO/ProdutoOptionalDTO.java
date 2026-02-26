package org.acme.application.dto.ProdutoDTO;

import java.math.BigDecimal;
import java.util.Optional;

public record ProdutoOptionalDTO(Optional<Long> id,
                                 Optional<String> nome,
                                 Optional<BigDecimal> preco,
                                 Optional<BigDecimal> estoque) {
}
