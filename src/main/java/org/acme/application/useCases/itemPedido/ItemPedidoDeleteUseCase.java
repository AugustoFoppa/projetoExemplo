package org.acme.application.useCases.itemPedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.domain.repositories.IItemPedidoRepository;

@ApplicationScoped
public class ItemPedidoDeleteUseCase {

    @Inject
    private IItemPedidoRepository itemPedidoRepository;

    @Transactional
    public void delete(Long id) {
        itemPedidoRepository.delete(id);
    }
}
