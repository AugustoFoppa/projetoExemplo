package org.acme.presentation.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.presentation.adapters.ProdutoAdapter;
import org.acme.application.dto.ProdutoDTO.ProdutoDTO;
import org.acme.application.dto.ProdutoDTO.ProdutoOptionalDTO;

@Path("/produto")
public class ProdutoController {

    @Inject
    private ProdutoAdapter produtoAdapter;

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPing() {
        return "Ping ProdutoController";
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(produtoAdapter.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(produtoAdapter.findById(id)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ProdutoDTO dto) {
        return Response.ok(produtoAdapter.create(dto)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        produtoAdapter.delete(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePut(@PathParam("id") Long id, ProdutoDTO dto) {
        produtoAdapter.update(id, dto);
        return Response.ok(dto).build();
    }

    @PATCH
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatch(@PathParam("id") Long id, ProdutoOptionalDTO dto) {
        ProdutoDTO responseDTO = produtoAdapter.updatePatch(id, dto);
        return Response.ok(responseDTO).build();
    }
}
