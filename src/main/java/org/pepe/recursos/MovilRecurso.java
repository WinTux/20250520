package org.pepe.recursos;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/movil")
public class MovilRecurso {
    List<String> listaMoviles = new ArrayList<String>();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> getListaMoviles(){
        return listaMoviles;
    }
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void agregarMovil(String movil){
        listaMoviles.add(movil);
    }
}
