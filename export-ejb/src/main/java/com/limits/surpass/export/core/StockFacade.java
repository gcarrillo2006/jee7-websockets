package com.limits.surpass.export.core;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.limits.surpass.export.generic.AbstractFacade;
import com.limits.surpass.export.model.Product;
import com.limits.surpass.export.websocket.ClientStockEndpoint;

/**
 * Clase de negocio compartida en toda la aplicación
 * @author german
 *
 */
@Singleton
public class StockFacade extends AbstractFacade<Product> {
	
	private final String webSocketAddress = "ws://localhost:8080/inscription-web/stock";
	
	//private Map<Integer, ClientStockEndpoint> clients = new HashMap<Integer, ClientStockEndpoint>();
	
	private ClientStockEndpoint client;
	
	private List<Product> products;
	
	@PersistenceContext(unitName = "ExportPU")
	private EntityManager em;

	public StockFacade() {
		super(Product.class);
		//reindexStock();
	}
	

	/**
	 * Metodo para obtener un producto en el listado registrado
	 * @param product
	 * @return
	 */
	private Product obtainProduct(Product product) {
		Product productReturn = null;
		if (product != null) {
			for (Product productStored : products) {
				if(productStored.getId().equals(product.getId())) {
					productReturn = productStored;
					break;
				}
			}
		}
		return productReturn;
	}
	
	public int getStock(Integer productId) {
		int stock = 0;
		for (Product productStored : products) {
			if(productStored.getId().equals(productId)) {
				stock = productStored.getStock();
				break;
			}
		}
		return stock;
	}

	/**
	 * Método para comprobar el stock de productos
	 * @return
	 */
	public int getStock(Product product) {
		int stock = 0;
		if (product != null) {
			stock = obtainProduct(product).getStock();
		}
		return stock;
	}
	
	/**
	 * Método para incrementar el stock en cada compra
	 * @param product
	 */
	public void increaseStock(Product product) {
		if (product != null) {
			Product productStored = obtainProduct(product);
			int stock = productStored.getStock();
			stock++;
			productStored.setStock(stock);
		}
		client.sendMessage("Update Stock");
		//clients.get(product.getId()).sendMessage("Update Clients");
	}

	/**
	 * Método para disminuir el stock en cada compra
	 */
	public void decreaseStock(Product product) {
		if (product != null) {
			Product productStored = obtainProduct(product);
			int stock = productStored.getStock();
			stock--;
			productStored.setStock(stock);
			
		}
		client.sendMessage("Update Stock");
		//clients.get(product.getId()).sendMessage("Update Clients");
	}

	@PostConstruct
	public void init() {
		reindexStock();
		try {
			client = new ClientStockEndpoint(new URI(webSocketAddress));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		/*for (Product product: products) {
			try {
				clients.put(product.getId(), new ClientStockEndpoint(new URI(webSocketAddress + product.getId().toString())));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	/**
	 * Método para reindexarStock
	 */	
	public void reindexStock() {
		try {
			products = findAll();
			/*for (ClientStockEndpoint client: clients.values()) {
				client.sendMessage("Update Clients");
			}*/
			if (client != null) {
				client.sendMessage("Update Stock");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	

}
