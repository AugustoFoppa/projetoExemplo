package org.acme.application.useCases.produto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.domain.entities.Produto;
import org.acme.domain.repositories.IProdutoRepository;

@ApplicationScoped
public class ProdutoUpdateUseCase {

    @Inject
    private IProdutoRepository produtoRepository;

    @Transactional
    public Produto update(Produto produto) {
        return produtoRepository.update(produto);
    }
}
