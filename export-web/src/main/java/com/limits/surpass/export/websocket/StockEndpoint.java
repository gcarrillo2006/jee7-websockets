package com.limits.surpass.export.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/stock")//("/stock/{productId}")
public class StockEndpoint {
	
	private static final Logger log = Logger.getLogger("StockEndpoint");
	
	private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	/*@Inject
	private StockFacade stockProduct;
	
	@OnMessage
	public void getStock(String message, @PathParam("productId") String productId) {
		Integer stock = stockProduct.getStock(Integer.parseInt(productId));
		log.info(new Integer(stock).toString() + message);
		for (Session session :  sessions) {
			try {
				session.getBasicRemote().sendText(stock.toString());
			} catch (IOException e) {
				log.warning(e.getMessage());
			}
		}
	}*/
	
	@OnMessage
	public void getStock(String message) {
		//Integer stock = stockProduct.getStock(Integer.parseInt(productId));
		//log.info(new Integer(stock).toString() + message);
		for (Session session :  sessions) {
			try {
				session.getBasicRemote().sendText("Update Clients");
			} catch (IOException e) {
				log.warning(e.getMessage());
			}
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		log.info("WebSocket opened: " + session.getId());
		sessions.add(session);
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		log.info("Closing a WebSocket due to " + reason.getReasonPhrase());
		sessions.remove(session);
	}
}
