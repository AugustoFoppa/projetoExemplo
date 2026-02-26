package org.acme.infra.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.domain.entities.Produto;
import org.acme.domain.exceptions.ResourceNotFoundException;
import org.acme.domain.repositories.IProdutoRepository;
import org.acme.infra.mappers.ProdutoEntityMapper;
import org.acme.infra.models.ProdutoEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProdutoRepository implements IProdutoRepository {

    private final PanacheRepository<ProdutoEntity> panache = new PanacheRepository<>() {};

    @Override
    public Produto create(Produto produto) {
        var entity = ProdutoEntityMapper.toEntity(produto);
        panache.persist(entity);
        return ProdutoEntityMapper.toDomain(entity);
    }

    @Override
    public Produto update(Produto produto) {
        this.findById(produto.getId()).orElseThrow(() -> new ResourceNotFoundException("ID nao encontrado!"));
        var entity = ProdutoEntityMapper.toEntity(produto);
        panache.getEntityManager().merge(entity);
        return ProdutoEntityMapper.toDomain(entity);
    }

    @Override
    public void delete(Long aLong) {
        var b = panache.deleteById(aLong);
        if(!b) {
            throw new ResourceNotFoundException("Nenhum Cliente encontrado com ID: " + aLong);
        }
    }

    @Override
    public Optional<Produto> findById(Long aLong) {
        var entity = panache.findById(aLong);
        if(entity == null) {
            return Optional.empty();
        }
        return Optional.of(ProdutoEntityMapper.toDomain(entity));
    }

    @Override
    public List<Produto> findByExample(Produto produto) {
        return List.of();
    }

    @Override
    public List<Produto> findAll() {
        List<ProdutoEntity> entityList = panache.listAll();
        return entityList.stream().map(ProdutoEntityMapper::toDomain).toList();
    }
}
