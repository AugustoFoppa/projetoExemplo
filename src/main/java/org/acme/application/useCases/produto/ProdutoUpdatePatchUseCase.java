package org.acme.application.useCases.produto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.application.dto.ProdutoDTO.ProdutoOptionalDTO;
import org.acme.domain.entities.Produto;

@ApplicationScoped
public class ProdutoUpdatePatchUseCase {

    @Inject
    private ProdutoFindByIdUseCase produtoFindByIdUseCase;
    @Inject
    private ProdutoUpdateUseCase updateUseCase;

    public Produto patch(Long id,ProdutoOptionalDTO dto) {
        Produto produto = produtoFindByIdUseCase.find(id);
        dto.nome().ifPresent(produto::setNome);
        dto.preco().ifPresent(produto::setPreco);
        dto.estoque().ifPresent(produto::setEstoque);
        return updateUseCase.update(produto);
    }
}
