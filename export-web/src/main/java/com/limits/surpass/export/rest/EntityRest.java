package com.limits.surpass.export.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.limits.surpass.export.model.Entity;
import com.limits.surpass.export.model.Operation;

@Path("/entity")
public class EntityRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@SecurityChecked
	public List<Entity> obtainEntity() {
		List<Entity> entities = new ArrayList<Entity>();
		Entity entity = new Entity();
		entity.setId(1L);
		entity.setOperation(Operation.INSERT);
		entity.setObject("Product");
		entities.add(entity);
		return entities;
	}

}
