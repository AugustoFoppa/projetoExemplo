package org.acme.presentation.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.application.dto.ItemPedidoDTO.ItemPedidoDTO;
import org.acme.application.mappers.IItemPedidoMapper;
import org.acme.application.mappers.ItemPedidoMapper;
import org.acme.application.useCases.itemPedido.*;
import org.acme.domain.entities.ItemPedido;

import java.util.List;

@ApplicationScoped
public class ItemPedidoAdapter {

    @Inject
    private ItemPedidoCreateUseCase itemPedidoCreateUseCase;
    @Inject
    private ItemPedidoDeleteUseCase itemPedidoDeleteUseCase;
    @Inject
    private ItemPedidoFindAllUseCase itemPedidoFindAllUseCase;
    @Inject
    private ItemPedidoFindByIdUseCase itemPedidoFindByIdUseCase;
    @Inject
    private ItemPedidoFindByExampleUseCase itemPedidoFindByExampleUseCase;

    @Inject
    IItemPedidoMapper itemPedidoMapper;

    public ItemPedidoDTO create(ItemPedidoDTO dto) {
        ItemPedido itemPedido = itemPedidoMapper.toDomain(dto);
        itemPedido = itemPedidoCreateUseCase.create(itemPedido);
        return itemPedidoMapper.toDTO(itemPedido);
    }

    public ItemPedidoDTO findById(Long id) {
        ItemPedido itemPedido = itemPedidoFindByIdUseCase.find(id);
        return itemPedidoMapper.toDTO(itemPedido);
    }

    public List<ItemPedidoDTO> findAll() {
        List<ItemPedido> list = itemPedidoFindAllUseCase.findAll();
        return list.stream().map(itemPedidoMapper::toDTO).toList();
    }

    public void delete(Long id) {
        itemPedidoDeleteUseCase.delete(id);
    }

    public List<ItemPedidoDTO> findByExample(ItemPedidoDTO dto) {
        ItemPedido itemPedido = itemPedidoMapper.toDomain(dto);
        List<ItemPedido> list = itemPedidoFindByExampleUseCase.findByExample(itemPedido);
        return list.stream().map(itemPedidoMapper::toDTO).toList();
    }
}
