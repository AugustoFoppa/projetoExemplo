package org.acme.application.useCases.itemPedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.domain.entities.ItemPedido;
import org.acme.domain.exceptions.ResourceNotFoundException;
import org.acme.domain.repositories.IItemPedidoRepository;

@ApplicationScoped
public class ItemPedidoFindByIdUseCase {

    @Inject
    private IItemPedidoRepository itemPedidoRepository;

    public ItemPedido find(Long id) {
        return itemPedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item Pedido nao encontrado"));
    }
}
