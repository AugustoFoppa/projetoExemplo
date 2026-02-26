package org.acme.application.useCases.pedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.domain.entities.Pedido;
import org.acme.domain.exceptions.ResourceNotFoundException;
import org.acme.domain.repositories.IPedidoRepository;

@ApplicationScoped
public class PedidoFindByIdUseCase {

    @Inject
    private IPedidoRepository pedidoRepository;

    public Pedido find(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto nao encontrado"));
    }
}
