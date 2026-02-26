package org.acme.application.useCases.pedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.domain.repositories.IPedidoRepository;

@ApplicationScoped
public class PedidoDeleteUseCase {

    @Inject
    private IPedidoRepository pedidoRepository;

    @Transactional
    public void delete(Long id) {
        pedidoRepository.delete(id);;
    }
}
