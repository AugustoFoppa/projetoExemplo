package org.acme.infra.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;
import org.acme.domain.entities.ItemPedido;
import org.acme.domain.entities.Pedido;
import org.acme.domain.exceptions.ResourceNotFoundException;
import org.acme.domain.repositories.IPedidoRepository;
import org.acme.infra.mappers.ItemPedidoEntityMapper;
import org.acme.infra.mappers.PedidoEntityMapper;
import org.acme.infra.models.ItemPedidoEntity;
import org.acme.infra.models.PedidoEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PedidoRepository implements IPedidoRepository {

    private final PanacheRepository<PedidoEntity> panache = new PanacheRepository<>() {};

    @Override
    public Pedido create(Pedido pedido) {
        var entity = PedidoEntityMapper.toEntity(pedido);
        panache.persist(entity);
        return PedidoEntityMapper.toDomain(entity);
    }

    @Override
    public Pedido update(Pedido pedido) {
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
    public Optional<Pedido> findById(Long aLong) {
        var entity = panache.findById(aLong);
        if(entity == null) {
            return Optional.empty();
        }
        return Optional.of(PedidoEntityMapper.toDomain(entity));
    }

    @Override
    public List<Pedido> findByExample(Pedido pedido) {
        return List.of();
    }

    @Override
    public List<Pedido> findAll() {
        List<PedidoEntity> entityList = panache.listAll();
        return entityList.stream().map(PedidoEntityMapper::toDomain).toList();
    }
}
