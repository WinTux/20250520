package org.pepe.recursos;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.Body;
import org.pepe.Models.Movil;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MovilJsonRecurso {
    List<Movil> listaMoviles = new ArrayList<Movil>();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerMoviles(){
        return Response.ok(listaMoviles).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarMovil(Movil movil){
        listaMoviles.add(movil);
        return Response.created(URI.create("/"+movil.getId())).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificarMovil(@PathParam("id") String id, Movil movil_nuevo){
        try{
            int id_numerico = Integer.parseInt(id);
            // Reemplazo
            //// Encontrar elemento original
            Movil original = null;
            for(Movil m : listaMoviles)
                if(m.getId() == id_numerico)
                    original = m;
            if(original == null)
                return Response.status(Response.Status.NOT_FOUND).build();
            //// Eliminar elemento original
            listaMoviles.remove(original);
            //// Agregar nuevo elemento
            listaMoviles.add(movil_nuevo);
            // return
            return Response.noContent().build();//204
        }catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
