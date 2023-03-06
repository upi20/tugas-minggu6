package id.kawahedukasi.controller;

import id.kawahedukasi.model.Item;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemController {
    @GET
    public Response getAll(){
        return Response.status(Response.Status.OK).entity(Item.findAll().list()).build();
    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id){
        Item item = Item.findById(id);

        if(item == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

    @POST
    @Transactional
    public Response update(Map<String, Object> request){
        Item item = new Item();
        item.name = request.get("name").toString();
        item.count = Integer.parseInt(request.get("count").toString());
        item.price = Long.parseLong(request.get("price").toString());
        item.type = request.get("type").toString();
        item.description = request.get("description").toString();

        // save
        item.persist();
        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Map<String, Object> request){
        Item item = Item.findById(id);

        if(item == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        item.name = request.get("name").toString();
        item.count = Integer.parseInt(request.get("count").toString());
        item.price = Long.parseLong(request.get("price").toString());
        item.type = request.get("type").toString();
        item.description = request.get("description").toString();

        // save
        item.persist();
        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id){
        Item item = Item.findById(id);
        if(item == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        item.delete();
        return Response.status(Response.Status.OK).entity(new HashMap<>()).build();
    }
}
