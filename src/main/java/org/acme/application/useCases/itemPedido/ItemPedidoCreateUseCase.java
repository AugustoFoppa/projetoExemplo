package org.acme.application.useCases.itemPedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.application.useCases.pedido.PedidoFindByIdUseCase;
import org.acme.domain.entities.ItemPedido;
import org.acme.domain.entities.Pedido;
import org.acme.domain.repositories.IItemPedidoRepository;
import org.acme.domain.repositories.IPedidoRepository;

@ApplicationScoped
public class ItemPedidoCreateUseCase {

    @Inject
    private IItemPedidoRepository itemPedidoRepository;
    @Inject
    private PedidoFindByIdUseCase findByIdUseCase;

    @Transactional
    public ItemPedido create(ItemPedido itemPedido) {
        Pedido pedido = findByIdUseCase.find(itemPedido.getPedidoID());
        itemPedido.setPedido(pedido);
        return itemPedidoRepository.create(itemPedido);
    }
}
