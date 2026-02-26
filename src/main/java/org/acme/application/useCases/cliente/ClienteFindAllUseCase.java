package org.acme.application.useCases.cliente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.domain.entities.Cliente;
import org.acme.domain.repositories.IClienteRepository;

import java.util.List;

@ApplicationScoped
public class ClienteFindAllUseCase {

    @Inject
    private IClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
