package id.kawahedukasi.controller;

import id.kawahedukasi.service.ItemService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemController {
    @Inject
    ItemService itemService;

    @GET
    public Response getAll(){
        return this.itemService.getAll();

    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id){
        return this.itemService.getOne(id);
    }

    @POST
    @Transactional
    public Response insert(Map<String, Object> request){
        return this.itemService.insert(request);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Map<String, Object> request){
        return this.itemService.update(id, request);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id){
        return this.itemService.delete(id);
    }
}
