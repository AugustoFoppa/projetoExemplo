package org.acme.application.useCases.produto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import org.acme.domain.repositories.IProdutoRepository;

@ApplicationScoped
public class ProdutoDeleteUseCase {

    @Inject
    private IProdutoRepository produtoRepository;

    @Transactional
    public void delete(Long id) throws BadRequestException {
        produtoRepository.delete(id);
    }
}
