package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/teste")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getOla() {
        return "Ola teste!!! 123";
    }
}
