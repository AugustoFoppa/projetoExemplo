package org.acme.infra.repositories;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import org.acme.domain.entities.ItemPedido;
import org.acme.domain.exceptions.ResourceNotFoundException;
import org.acme.domain.repositories.IItemPedidoRepository;
import org.acme.infra.mappers.ClienteEntityMapper;
import org.acme.infra.mappers.IItemPedidoEntityMapper;
import org.acme.infra.mappers.ItemPedidoEntityMapper;
import org.acme.infra.models.ClienteEntity;
import org.acme.infra.models.ItemPedidoEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class ItemPedidoRepository implements IItemPedidoRepository {

    private final PanacheRepository<ItemPedidoEntity> panache = new PanacheRepository<>() {};


    IItemPedidoEntityMapper itemPedidoEntityMapper;

    @Override
    public ItemPedido create(ItemPedido itemPedido) {
        var entity = itemPedidoEntityMapper.toEntity(itemPedido);

        panache.persist(entity);
        return itemPedidoEntityMapper.toDomain(entity);
    }

    @Override
    public ItemPedido update(ItemPedido itemPedido) {
        return null;
    }

    @Override
    public void delete(Long aLong) {
        var b = panache.deleteById(aLong);
        if(!b) {
            throw new ResourceNotFoundException("Nenhum CLiente encontrado com ID: " + aLong);
        }
    }

    @Override
    public Optional<ItemPedido> findById(Long aLong) {
        var entity = panache.findById(aLong);
        if(entity == null) {
            return Optional.empty();
        }
        return Optional.of(itemPedidoEntityMapper.toDomain(entity));
    }

    @Override
    public List<ItemPedido> findByExample(ItemPedido itemPedido) {

        ItemPedidoEntity entity = itemPedidoEntityMapper.toEntity(itemPedido);

        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        if (entity.getProdutoEntity() != null) {
            if (!query.isEmpty()) query.append(" and ");
            query.append("produtoEntity.id = :produto_id");
            params.put("produto_id", entity.getProdutoEntity().getId());
        }

        if (entity.getPedidoEntity() != null) {
            if (!query.isEmpty()) query.append(" and ");
            query.append("pedidoEntity.id = :pedido_id");
            params.put("pedido_id", entity.getPedidoEntity().getId());
        }

        if (entity.getQuantidade() != null) {
            if (!query.isEmpty()) query.append(" and ");
            query.append("quantidade = :quantidade");
            params.put("quantidade", entity.getQuantidade());
        }

        if (entity.getPrecoUnitario() != null) {
            if (!query.isEmpty()) query.append(" and ");
            query.append("precoUnitario = :precoUnitario");
            params.put("precoUnitario", entity.getPrecoUnitario());
        }

        PanacheQuery<ItemPedidoEntity> panacheQuery = panache.find(query.toString(), params);
        return panacheQuery.stream().map(itemPedidoEntityMapper::toDomain).toList();
    }

    @Override
    public List<ItemPedido> findAll() {
        List<ItemPedidoEntity> entityList = panache.listAll();
        return entityList.stream().map(itemPedidoEntityMapper::toDomain).toList();
    }
}
