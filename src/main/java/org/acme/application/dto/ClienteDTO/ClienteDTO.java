package org.acme.application.dto.ClienteDTO;

public record ClienteDTO(Long id,
                         String nome,
                         String email,
                         String cpf) {
}
