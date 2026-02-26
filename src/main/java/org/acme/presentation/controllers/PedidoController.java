package org.acme.presentation.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.presentation.adapters.PedidoAdapter;
import org.acme.application.dto.PedidoDTO.PedidoDTO;

@Path("/pedido")
public class PedidoController {

    @Inject
    private PedidoAdapter pedidoAdapter;

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPing() {
        return "Ping PedidoController";
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(pedidoAdapter.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(pedidoAdapter.findById(id)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PedidoDTO dto) {
        return Response.ok(pedidoAdapter.create(dto)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        pedidoAdapter.delete(id);
        return Response.noContent().build();
    }
}
