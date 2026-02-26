package org.acme.application.useCases.itemPedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.domain.entities.ItemPedido;
import org.acme.domain.repositories.IItemPedidoRepository;

import java.util.List;

@ApplicationScoped
public class ItemPedidoFindAllUseCase {

    @Inject
    private IItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }
}
