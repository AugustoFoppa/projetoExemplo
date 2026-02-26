package org.acme.presentation.controllers;

import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.presentation.adapters.ClienteAdapter;
import org.acme.application.dto.ClienteDTO.ClienteDTO;

@Path("/cliente")
public class ClienteController {

    @Inject
    private ClienteAdapter clienteAdapter;

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPing() {
        return "Ping ClienteController";
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(clienteAdapter.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(clienteAdapter.findById(id)).build();
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ClienteDTO dto) {
        return Response.ok(clienteAdapter.create(dto)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            clienteAdapter.delete(id);
            return Response.noContent().build();
        } catch(EntityNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        clienteAdapter.update(id, dto);
        return Response.ok(dto).build();
    }
}
