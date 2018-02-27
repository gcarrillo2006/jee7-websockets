package com.limits.surpass.export.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.limits.surpass.export.core.ProductFacade;
import com.limits.surpass.export.core.StockFacade;
import com.limits.surpass.export.model.Product;

/**
 * Clase para administrar el formulario de los productos
 * @author german
 *
 */
@Named
@SessionScoped
public class ProductBean implements Serializable {
	
	/**
	 * Creado con serializable por utilizar CDI
	 */
	private static final long serialVersionUID = 1L;
	
	private int stockRequest;

	private Product product;
	
	@Inject
	private StockFacade stockProduct;
	
	@Inject
	private ProductFacade adminProduct;
	
	public ProductBean() {
		this.stockRequest = 0;
	}
	
	public int getStockRequest() {
		return stockRequest;
	}

	public void setStockRequest(int stockRequest) {
		this.stockRequest = stockRequest;
	}

	public int getStock() {
		return stockProduct.getStock(product);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Map.Entry<Product,Integer>> getProductList() {
		Set<Map.Entry<Product, Integer>> productSet = adminProduct.getProducts().entrySet();
		return new ArrayList<Map.Entry<Product, Integer>>(productSet);
	}

	public List<Map.Entry<Product,Integer>> getProductFullList() throws Exception {
		Set<Map.Entry<Product, Integer>> productSet = adminProduct.getProductStock().entrySet();
		return new ArrayList<Map.Entry<Product, Integer>>(productSet);
	}
	
	public void asignProduct(Product product) {
		this.product = product;
	}

	public void addProduct() {
		for (int i = 0; i < stockRequest; i++) {
			adminProduct.addProduct(product);
		}
		stockRequest = 0;
	}
	
	public void removeProduct(Product product) {
		adminProduct.removeProduct(product);
	}
	
	public void orderProducts() {
		try {
			adminProduct.order();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
