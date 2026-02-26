package org.acme.presentation.infra;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.presentation.dto.response.ErroResponse;
import org.acme.domain.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {
    @Override
    public Response toResponse(ResourceNotFoundException e) {
        ErroResponse erro = new ErroResponse(404, e.getMessage(), LocalDateTime.now());

        return Response.status(Response.Status.NOT_FOUND).entity(erro).build();
    }
}
