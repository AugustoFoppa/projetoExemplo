package org.acme.presentation.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.presentation.adapters.ItemPedidoAdapter;
import org.acme.application.dto.ItemPedidoDTO.ItemPedidoDTO;

@Path("/itemPedido")
public class ItemPedidoController {

    @Inject
    private ItemPedidoAdapter itemPedidoAdapter;

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPing() {
        return "Ping ItemPedidoController";
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(itemPedidoAdapter.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(itemPedidoAdapter.findById(id)).build();
    }

    @POST
    @Path("/findByExample")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByExample(ItemPedidoDTO dto) {
        return Response.ok(itemPedidoAdapter.findByExample(dto)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ItemPedidoDTO dto) {
        return Response.ok(itemPedidoAdapter.create(dto)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        itemPedidoAdapter.delete(id);
        return Response.noContent().build();
    }
}
