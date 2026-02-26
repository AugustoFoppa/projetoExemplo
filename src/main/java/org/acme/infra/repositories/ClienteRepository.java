package org.acme.infra.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import org.acme.domain.entities.Cliente;
import org.acme.domain.exceptions.ResourceNotFoundException;
import org.acme.domain.repositories.IClienteRepository;
import org.acme.infra.mappers.ClienteEntityMapper;
import org.acme.infra.mappers.ClienteMapper;
import org.acme.infra.models.ClienteEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteRepository implements IClienteRepository {

    private final PanacheRepository<ClienteEntity> panache = new PanacheRepository<>() {};

    @Inject
    ClienteMapper clienteMapper;

    @Override
    public Cliente create(Cliente cliente) {
        var entity = ClienteEntityMapper.toEntity(cliente);
        panache.persist(entity);
        return ClienteEntityMapper.toDomain(entity);
    }

    @Override
    public Cliente update(Cliente cliente) {
        this.findById(cliente.getId()).orElseThrow(() -> new ResourceNotFoundException("ID nao encontrado!"));
        var entity = ClienteEntityMapper.toEntity(cliente);
        panache.getEntityManager().merge(entity);
        return ClienteEntityMapper.toDomain(entity);
    }

    @Override
    public void delete(Long aLong) {
        var b = panache.deleteById(aLong);
        if(!b) {
            throw new ResourceNotFoundException("Nenhum CLiente encontrado com ID: " + aLong);
        }
    }

    @Override
    public Optional<Cliente> findById(Long aLong) {
        var entity = panache.findById(aLong);
        if(entity == null) {
            return Optional.empty();
        }
        return Optional.of(ClienteEntityMapper.toDomain(entity));
    }

    @Override
    public List<Cliente> findByExample(Cliente cliente) {
        return List.of();
    }

    @Override
    public List<Cliente> findAll() {
        List<ClienteEntity> entityList = panache.listAll();
        return entityList.stream().map(clienteMapper::toDomain).toList();
    }
}
