package org.acme.presentation.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.application.dto.PedidoDTO.PedidoDTO;
import org.acme.application.mappers.IPedidoMapper;
import org.acme.application.mappers.PedidoMapper;
import org.acme.application.useCases.pedido.PedidoCreateUseCase;
import org.acme.application.useCases.pedido.PedidoDeleteUseCase;
import org.acme.application.useCases.pedido.PedidoFindAllUseCase;
import org.acme.application.useCases.pedido.PedidoFindByIdUseCase;
import org.acme.domain.entities.Pedido;

import java.util.List;

@ApplicationScoped
public class PedidoAdapter {

    @Inject
    private PedidoCreateUseCase pedidoCreateUseCase;
    @Inject
    private PedidoDeleteUseCase pedidoDeleteUseCase;
    @Inject
    private PedidoFindAllUseCase pedidoFindAllUseCase;
    @Inject
    private PedidoFindByIdUseCase pedidoFindByIdUseCase;

    @Inject
    private IPedidoMapper pedidoMapper;

    public PedidoDTO create(PedidoDTO dto) {
        Pedido pedido = pedidoMapper.toDomain(dto);
        pedido = pedidoCreateUseCase.create(pedido);
        return pedidoMapper.toDTO(pedido);
    }

    public PedidoDTO findById(Long id) {
        Pedido pedido = pedidoFindByIdUseCase.find(id);
        return pedidoMapper.toDTO(pedido);
    }

    public List<PedidoDTO> findAll() {
        List<Pedido> list = pedidoFindAllUseCase.findAll();
        return list.stream().map(pedidoMapper::toDTO).toList();
    }

    public void delete(Long id) {
        pedidoDeleteUseCase.delete(id);
    }
}
