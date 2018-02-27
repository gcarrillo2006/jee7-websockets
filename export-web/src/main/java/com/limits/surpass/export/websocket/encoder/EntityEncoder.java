package com.limits.surpass.export.websocket.encoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.limits.surpass.export.model.Entity;


public class EntityEncoder implements Encoder.Text<Entity>{

	@Override
	public void init(EndpointConfig config) {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public String encode(Entity entity) throws EncodeException {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(entity);
	}

}
