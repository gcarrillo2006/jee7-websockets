package com.limits.surpass.export.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.limits.surpass.export.model.Entity;
import com.limits.surpass.export.websocket.decoder.EntityDecoder;
import com.limits.surpass.export.websocket.encoder.EntityEncoder;

@ServerEndpoint(value = "/entity/{client-id}", encoders = {EntityEncoder.class}, decoders = {EntityDecoder.class})
public class EntityEndpoint {
	
	private static final Logger log = Logger.getLogger("EntityEndpoint");
	
	private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public String onMessage(Entity entity, Session session, @PathParam("client-id") String clientId) throws EncodeException {
		for (Session s :  sessions) {
			try {
				s.getBasicRemote().sendObject(entity);
			} catch (IOException e) {
				log.warning(e.getMessage());
			}
		}
		return "Message was received by socket mediator and processed: " + entity.toString();
	}
	
	@OnOpen
	public void onOpen(Session session, @PathParam("client-id") String clientId) {
		log.info("WebSocket opened: " + clientId);
		sessions.add(session);
	}
	
	@OnClose
	public void onClose(Session session, @PathParam("client-id") String clientId, CloseReason reason) {
		log.info("Closing a WebSocket " + clientId + " due to " + reason.getReasonPhrase());
		sessions.remove(session);
	}
}
