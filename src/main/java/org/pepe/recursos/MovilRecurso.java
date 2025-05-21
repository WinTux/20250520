package org.pepe.recursos;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/movil")
public class MovilRecurso {
    List<String> listaMoviles = new ArrayList<String>();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getListaMoviles(){
        return Response.ok(listaMoviles).build();
    }
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response agregarMovil(String movil){
        listaMoviles.add(movil);
        return Response.created(URI.create("/movil/"+movil)).build();
    }
    @PUT
    @Path("/{actual}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response modificarMovil(@PathParam("actual") String actual, @QueryParam("nombre") String nuevo){
        listaMoviles = listaMoviles.stream().map(
                movil->{
                    if(movil.equals(actual))
                        return nuevo;
                    else
                        return actual;
                })
                .collect(Collectors.toList());
        return Response.ok(listaMoviles).build();
    }
    @DELETE
    @Path("/{eliminable}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response eliminarMovil(@PathParam("eliminable") String eliminable){
        if(listaMoviles.remove(eliminable))
            return Response.ok(listaMoviles).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
