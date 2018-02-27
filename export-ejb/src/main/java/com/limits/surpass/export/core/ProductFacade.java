package com.limits.surpass.export.core;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.limits.surpass.export.generic.AbstractFacade;
import com.limits.surpass.export.model.Product;

/**
 * Clase para ejemplificar un tipo de ejb de tipo stateful
 * @author german
 *
 */
@Stateful
public class ProductFacade extends AbstractFacade<Product> {
	
	private static final Logger log = Logger.getLogger("ProductFacade");
	
	@PersistenceContext(unitName = "ExportPU")
	private EntityManager em;
	
	@EJB
	private StockFacade stockFacade;
	
	private Date startDate;
	
	private List<Product> productList;
	
	private Map<Product, Integer> productStock = new HashMap<Product, Integer>();
	
	private Map<Product, Integer> products = new HashMap<Product, Integer>(); //Manejo de estado

	public ProductFacade() {
		super(Product.class);
	}
	
	public Map<Product, Integer> getProductStock() {
		for (Product product : productStock.keySet()) {
			productStock.put(product, stockFacade.getStock(product));
		}
		return productStock;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	/**
	 * Método para agregar un producto
	 * @param product
	 */
	public void addProduct(Product product) {
		int stock = stockFacade.getStock(product);
		if (stock > 0) {
			stockFacade.decreaseStock(product);
			int value = 0;
			if (products.get(product) != null) {
				value = products.get(product);
			}
			products.put(product, value + 1);
		}
	}
	
	/**
	 * Método para disminuir un producto
	 * @param product
	 */
	public void removeProduct(Product product) {
		stockFacade.increaseStock(product);
		if (products.containsKey(product) && products.get(product) == 1) {
			products.remove(product);
		} else if (products.containsKey(product)) {
			products.put(product, products.get(product) - 1);
		}
	}
	
	/**
	 * Método para ordenar los productos
	 * @throws Exception
	 */
	@Remove //Termina la transacción y se rompe el estado
	public void order() throws Exception {
		for (Product productTemporal : products.keySet()) {
			update(productTemporal);
		}
		stockFacade.reindexStock();
		log.info("Total de productos vendidos " + products.size());
	}
	
	@Remove
	public String cancel() {
		stockFacade.reindexStock();
		Date endDate = new Date();
		return "Transaccion cancelada exitosamente, realizada en: " + new Long(endDate.getTime() - startDate.getTime()).toString();
	}
	
	@PostConstruct
	public void init() {
		log.info("Creación de instancia de EJB");
		startDate = new Date();
		try {
			productList = findAll();
			for (Product product : productList) {
				productStock.put(product, stockFacade.getStock(product));
			}
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
