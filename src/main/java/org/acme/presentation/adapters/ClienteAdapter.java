package org.acme.presentation.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.application.dto.ClienteDTO.ClienteDTO;
import org.acme.application.mappers.ClienteMapper;
import org.acme.application.mappers.IClienteMapper;
import org.acme.application.useCases.cliente.*;
import org.acme.domain.entities.Cliente;

import java.util.List;

@ApplicationScoped
public class ClienteAdapter {

    private final ClienteCreateUseCase clienteCreateUseCase;
    private final ClienteFindByIdUseCase clienteFindByIdUseCase;
    private final ClienteDeleteUseCase clienteDeleteUseCase;
    private final ClienteFindAllUseCase clienteFindAllUseCase;
    private final ClienteUpdateUseCase clienteUpdateUseCase;

    @Inject
    IClienteMapper clienteMapper;

    public ClienteAdapter(ClienteCreateUseCase clienteCreateUseCase, ClienteFindByIdUseCase clienteFindByIdUseCase, ClienteDeleteUseCase clienteDeleteUseCase, ClienteFindAllUseCase clienteFindAllUseCase, ClienteUpdateUseCase clienteUpdateUseCase) {
        this.clienteCreateUseCase = clienteCreateUseCase;
        this.clienteFindByIdUseCase = clienteFindByIdUseCase;
        this.clienteDeleteUseCase = clienteDeleteUseCase;
        this.clienteFindAllUseCase = clienteFindAllUseCase;
        this.clienteUpdateUseCase = clienteUpdateUseCase;
    }

    public ClienteDTO create(ClienteDTO dto) {
        Cliente cliente = ClienteMapper.toDomain(dto);
        cliente = clienteCreateUseCase.create(cliente);
        return clienteMapper.toDTO(cliente);
    }

    public ClienteDTO findById(Long id) {
        Cliente cliente =  clienteFindByIdUseCase.find(id);
        return clienteMapper.toDTO(cliente);
    }

    public List<ClienteDTO> findAll() {
        List<Cliente> list = clienteFindAllUseCase.findAll();
        return list.stream().map(clienteMapper::toDTO).toList();
    }

    public void delete(Long id) {
        clienteDeleteUseCase.delete(id);
    }

    public ClienteDTO update(Long id, ClienteDTO dto) {
        Cliente cliente = clienteMapper.toDomain(dto);
        cliente.setId(id);
        cliente = clienteUpdateUseCase.update(cliente);
        return clienteMapper.toDTO(cliente);
    }
}
