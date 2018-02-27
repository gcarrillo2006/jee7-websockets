package com.limits.surpass.export.util;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.JsonObject;
import com.limits.surpass.export.model.Entity;

public class EntityEncoder implements Encoder.Text<Entity> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(Entity entity) throws EncodeException {
		JsonObject jsonEntity = new JsonObject();
		jsonEntity.addProperty("object", entity.getObject());
		jsonEntity.addProperty("operation", entity.getOperation().toString());
		jsonEntity.addProperty("id", entity.getId());
		return jsonEntity.toString();
	}


}
