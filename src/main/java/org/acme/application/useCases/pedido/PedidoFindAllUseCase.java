package org.acme.application.useCases.pedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.domain.entities.Pedido;
import org.acme.domain.repositories.IPedidoRepository;

import java.util.List;

@ApplicationScoped
public class PedidoFindAllUseCase {

    @Inject
    IPedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
