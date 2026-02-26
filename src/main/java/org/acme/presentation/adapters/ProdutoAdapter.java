package org.acme.presentation.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.application.dto.ProdutoDTO.ProdutoDTO;
import org.acme.application.dto.ProdutoDTO.ProdutoOptionalDTO;
import org.acme.application.mappers.ProdutoMapper;
import org.acme.application.useCases.produto.*;
import org.acme.domain.entities.Produto;

import java.util.List;

@ApplicationScoped
public class ProdutoAdapter {

    @Inject
    private ProdutoCreateUseCase produtoCreateUseCase;
    @Inject
    private ProdutoDeleteUseCase produtoDeleteUseCase;
    @Inject
    private ProdutoFindAllUseCase produtoFindAllUseCase;
    @Inject
    private ProdutoFindByIdUseCase produtoFindByIdUseCase;
    @Inject
    private ProdutoUpdateUseCase produtoUpdateUseCase;
    @Inject
    private ProdutoUpdatePatchUseCase produtoUpdatePatchUseCase;

    public ProdutoDTO create(ProdutoDTO dto) {
        Produto produto = ProdutoMapper.toDomain(dto);
        produto = produtoCreateUseCase.create(produto);
        return ProdutoMapper.toDTO(produto);
    }

    public ProdutoDTO findById(Long id) {
        Produto produto = produtoFindByIdUseCase.find(id);
        return ProdutoMapper.toDTO(produto);
    }

    public List<ProdutoDTO> findAll() {
        List<Produto> list = produtoFindAllUseCase.findAll();
        return list.stream().map(ProdutoMapper::toDTO).toList();
    }

    public void delete(Long id) {
        produtoDeleteUseCase.delete(id);
    }

    public ProdutoDTO update(Long id, ProdutoDTO dto) {
        Produto produto = ProdutoMapper.toDomain(dto);
        produto.setId(id);
        produto = produtoUpdateUseCase.update(produto);
        return ProdutoMapper.toDTO(produto);
    }

    public ProdutoDTO updatePatch(Long id, ProdutoOptionalDTO dto) {
        Produto produto = produtoUpdatePatchUseCase.patch(id, dto);
        return ProdutoMapper.toDTO(produto);
    }
}
