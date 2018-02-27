package com.limits.surpass.export.util;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.limits.surpass.export.model.Entity;

public class EntityDecoder implements Decoder.Text<Entity> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity decode(String s) throws DecodeException {
		//JsonObject jsonEntity = new JsonR
		return null;
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		return false;
	}


}
