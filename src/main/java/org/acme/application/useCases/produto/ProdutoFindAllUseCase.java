package org.acme.application.useCases.produto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.domain.entities.Produto;
import org.acme.domain.repositories.IProdutoRepository;

import java.util.List;

@ApplicationScoped
public class ProdutoFindAllUseCase {

    @Inject
    private IProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
