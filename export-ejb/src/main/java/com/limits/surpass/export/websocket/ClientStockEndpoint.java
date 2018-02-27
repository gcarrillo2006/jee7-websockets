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
public class ClientStockEndpoint {
	
	private static final Logger log = Logger.getLogger("ClientStockEndopoint");

	public ClientStockEndpoint(URI endpointURI) {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(this, endpointURI);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	Session userSession = null;
	
	@OnOpen
	public void onOpen(Session session) {
		log.info("Client opening websocket");
		this.userSession = session;
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		log.info("Client closing websocket");
		this.userSession = null;
	}
	
	@OnMessage
	public void onMessage(String message) {
		log.info("Client received message " + message);
	}
	
	public void sendMessage(String message) {
		this.userSession.getAsyncRemote().sendText(message);
	}
}
