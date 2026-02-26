package org.acme.application.useCases.cliente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import org.acme.domain.entities.Cliente;
import org.acme.domain.exceptions.ResourceNotFoundException;
import org.acme.domain.repositories.IClienteRepository;

@ApplicationScoped
public class ClienteFindByIdUseCase {

    @Inject
    private IClienteRepository clienteRepository;

    public Cliente find(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado"));
    }
}
