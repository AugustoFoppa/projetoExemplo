package org.acme.application.dto.PedidoDTO;

import org.acme.application.dto.ClienteDTO.ClienteDTO;
import org.acme.application.dto.ItemPedidoDTO.ItemPedidoDTO;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(Long id,
                        LocalDateTime dateTime,
                        ClienteDTO cliente,
                        List<ItemPedidoDTO> itemPedidoList) {
}
