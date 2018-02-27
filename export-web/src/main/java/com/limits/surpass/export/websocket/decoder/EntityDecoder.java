package com.limits.surpass.export.websocket.decoder;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.limits.surpass.export.model.Entity;


public class EntityDecoder implements Decoder.Text<Entity>{

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public Entity decode(String string) throws DecodeException {
		Gson gson = new GsonBuilder().create();
		System.out.println(string);
		return gson.fromJson(string, Entity.class);
	}

	@Override
	public boolean willDecode(String string) {
		return true;
	}

}
