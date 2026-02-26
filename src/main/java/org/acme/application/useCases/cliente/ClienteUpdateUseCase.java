package org.acme.application.useCases.cliente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.domain.entities.Cliente;
import org.acme.domain.repositories.IClienteRepository;

@ApplicationScoped
public class ClienteUpdateUseCase {

    @Inject
    private IClienteRepository clienteRepository;

    @Transactional
    public Cliente update(Cliente cliente) {
        return clienteRepository.update(cliente);
    }
}
