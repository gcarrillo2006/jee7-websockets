package com.limits.surpass.export.websocket;

import java.net.URI;
import java.util.logging.Logger;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class ClientEntityEndpoint {
	
	private static final Logger log = Logger.getLogger("ClientEntityEndpoint");

	public ClientEntityEndpoint(URI endpointURI) {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(this, endpointURI);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	Session session = null;
	
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		this.session = null;
	}
	
	@OnMessage
	public void onMessage(String message) {
		log.info("client received message " + message);
	}
	
	public void sendMessage(String message) {
		this.session.getAsyncRemote().sendText(message);
	}
}
