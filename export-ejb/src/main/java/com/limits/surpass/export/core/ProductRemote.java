package com.limits.surpass.export.core;

import java.util.List;

import com.limits.surpass.export.model.Branch;
import com.limits.surpass.export.model.Product;

public interface ProductRemote {
	
	public List<Product> findProducts(Branch branch, String name);

    public List<Product> findProducts(String name);

    public void persist(Product product);

    public void delete(Product product);
    
}
