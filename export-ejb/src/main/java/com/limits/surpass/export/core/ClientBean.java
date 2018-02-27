package com.limits.surpass.export.core;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.limits.surpass.export.model.Branch;
import com.limits.surpass.export.model.Enterprise;
import com.limits.surpass.export.model.Product;
import com.limits.surpass.export.model.Reservation;
import com.limits.surpass.export.model.Stock;
import com.limits.surpass.export.model.User;

/**
 * Session Bean implementation class ClientBean
 */
@Stateless
@LocalBean
/*@Path("/Movil")
@Produces({ "application/json" })*/
@Remote(ClientRemote.class)
public class ClientBean implements ClientRemote {

	@PersistenceContext(unitName = "ExportPU")
    private EntityManager em;
	
	@EJB
	private EnterpriseBean enterpriseBean;
	
	@EJB
	private BranchBean branchBean;

	@EJB
	private ProductBean productBean;
	
	@EJB
	private StockBean stockBean;
	
	@EJB
	private ReservationBean reservationBean;
	
    /**
     * Default constructor. 
     */
    public ClientBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean applicationEnabled(String username, String password) {
		TypedQuery<User> query = this.em.createNamedQuery("findUser", User.class)
			.setParameter("username", username).setParameter("password", password);
		if (query.getResultList() != null && !query.getResultList().isEmpty()) {
			User u = query.getSingleResult();
			return u.getActive() == null ? false : u.getActive();
		}
		return false;
	}

	@Override
	/*@GET
	@Path("/Enterprises")*/
	public List<Enterprise> obtainEnterprises() {
		return this.enterpriseBean.findEnterprises("");
	}
	
	@Override
	/*@GET
	@Path("/Branchs/{username}/{password}")*/
	public List<Branch> obtainBranchs(String username, String password) {
		if(this.applicationEnabled(username, password)) {
			return this.branchBean.findBranches(this.enterpriseBean.findEnterpriseByUsername(username), null);
		}
		return null;
	}

	@Override
	public List<Product> obtainProducts(String username, String password,
			Branch branch) {
		if(this.applicationEnabled(username, password)) {
			return this.productBean.findProducts(branch == null 
				? this.branchBean.findBranchByUsername(username).get() : branch, null);
		}
		return null;
	}

	@Override
	public List<Stock> obtainStocks(String username, String password,
			Product product) {
		if(this.applicationEnabled(username, password)) {
			return this.stockBean.findStocks(product);
		}
		return null;
	}

	@Override
	public List<Reservation> obtainReservations(String username,
			String password, Stock stock) {
		if(this.applicationEnabled(username, password)) {
			return this.reservationBean.findReservations(stock);
		}
		return null;
	}

	@Override
	public Branch persistBranch(String username, String password, Branch branch) {
		if(this.applicationEnabled(username, password)) {
			this.branchBean.persist(branch);
			return branch;
		}
		return null;
	}

	@Override
	public Product persistProduct(String username, String password,
			Product product) {
		if(this.applicationEnabled(username, password)) {
			this.productBean.persist(product);
			return product;
		}
		return null;
	}

	@Override
	public Stock persistStock(String username, String password, Stock stock) {
		if(this.applicationEnabled(username, password)) {
			this.stockBean.persist(stock);
			return stock;
		}
		return null;
	}

	@Override
	public Reservation persistReservation(String username, String password,
			Reservation reservation) {
		if(this.applicationEnabled(username, password)) {
			this.reservationBean.persist(reservation);
			return reservation;
		}
		return null;
	}

	@Override
	public void deleteBranch(String username, String password, Branch branch) {
		if(this.applicationEnabled(username, password)) {
			this.branchBean.delete(branch);
		}
	}

	@Override
	public void deleteProduct(String username, String password, Product product) {
		if(this.applicationEnabled(username, password)) {
			this.productBean.delete(product);
		}
	}

	@Override
	public void deleteStock(String username, String password, Stock stock) {
		if(this.applicationEnabled(username, password)) {
			this.stockBean.delete(stock);
		}		
	}

	@Override
	public void deleteReservation(String username, String password,
			Reservation reservation) {
		if(this.applicationEnabled(username, password)) {
			this.reservationBean.delete(reservation);
		}		
	}

}
