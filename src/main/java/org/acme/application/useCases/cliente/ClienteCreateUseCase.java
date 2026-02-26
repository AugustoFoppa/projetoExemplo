package org.acme.application.useCases.cliente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.domain.entities.Cliente;
import org.acme.domain.repositories.IClienteRepository;

@ApplicationScoped
public class ClienteCreateUseCase {

    private final IClienteRepository clienteRepository;

    public ClienteCreateUseCase(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente create(Cliente cliente) {
        return clienteRepository.create(cliente);
    }
}
