package com.limits.surpass.export.core;

import java.util.List;

import com.limits.surpass.export.model.Branch;
import com.limits.surpass.export.model.Enterprise;
import com.limits.surpass.export.model.Product;
import com.limits.surpass.export.model.Reservation;
import com.limits.surpass.export.model.Stock;

public interface ClientRemote {
	
	public List<Enterprise> obtainEnterprises();
	
	public Boolean applicationEnabled(String username, String password);

	public List<Branch> obtainBranchs(String username, String password);
	
	public List<Product> obtainProducts(String username, String password, Branch branch);
	
	public List<Stock> obtainStocks(String username, String password, Product product);
	
	public List<Reservation> obtainReservations(String username, String password, Stock stock);
	
	public Branch persistBranch(String username, String password, Branch branch);
	
	public Product persistProduct(String username, String password, Product product);
	
	public Stock persistStock(String username, String password, Stock stock);
	
	public Reservation persistReservation(String username, String password, Reservation reservation);
	
	public void deleteBranch(String username, String password, Branch branch);
	
	public void deleteProduct(String username, String password, Product product);
	
	public void deleteStock(String username, String password, Stock stock);
	
	public void deleteReservation(String username, String password, Reservation reservation);
}
