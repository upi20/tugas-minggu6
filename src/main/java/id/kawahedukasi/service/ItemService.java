package id.kawahedukasi.service;

import id.kawahedukasi.model.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class ItemService {

    public Response getAll() {
        return Response.status(Response.Status.OK).entity(Item.findAll().list()).build();
    }

    public Response getOne(Long id) {
        Item item = Item.findById(id);

        if (item == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

    public Response insert(Map<String, Object> request) {
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

    public Response update(Long id, Map<String, Object> request) {
        Item item = Item.findById(id);

        if (item == null) {
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

    public Response delete(Long id) {
        Item item = Item.findById(id);
        if (item == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        item.delete();
        return Response.status(Response.Status.OK).entity(new HashMap<>()).build();
    }
}
