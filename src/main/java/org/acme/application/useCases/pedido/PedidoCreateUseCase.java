package org.acme.application.useCases.pedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.domain.entities.Pedido;
import org.acme.domain.repositories.IPedidoRepository;

@ApplicationScoped
public class PedidoCreateUseCase {

    @Inject
    private IPedidoRepository pedidoRepository;

    @Transactional
    public Pedido create(Pedido pedido) {
        return pedidoRepository.create(pedido);
    }
}
