package org.acme.presentation.dto.response;

import java.time.LocalDateTime;

public record ErroResponse(Integer status, String message, LocalDateTime timestamp) {
}
