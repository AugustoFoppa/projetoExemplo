package org.acme.application.useCases.produto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.domain.entities.Produto;
import org.acme.domain.exceptions.ResourceNotFoundException;
import org.acme.domain.repositories.IProdutoRepository;

@ApplicationScoped
public class ProdutoFindByIdUseCase {

    @Inject
    private IProdutoRepository produtoRepository;

    public Produto find(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto nao encontrado"));
    }
}
