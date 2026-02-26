package org.acme.application.useCases.cliente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import org.acme.domain.repositories.IClienteRepository;

@ApplicationScoped
public class ClienteDeleteUseCase {

    @Inject
    private IClienteRepository clienteRepository;

    @Transactional
    public void delete(Long id) throws BadRequestException {
        clienteRepository.delete(id);
    }
}
