package com.limits.surpass.export.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity that is used to store reservations
 * @author German
 *
 */
@Entity
@Table(name = "reservation", schema = "application")
@NamedQueries({
    @NamedQuery(name = "findReservationsByStock", query = "select r from Reservation r "
        + "where r.stock = :stock"),
    @NamedQuery(name = "findReservationsByProduct", query = "select r from Reservation r "
        + "where r.product = :product")
})
public class Reservation implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20)
	private Long id;

	/**
	 * Date used to store the checkOut date 
	 */
	@Column(name = "check_out", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkOut;
	
	@ManyToOne(targetEntity = Stock.class)
	@JoinColumn(name = "stock_id", referencedColumnName = "id")
	private Stock stock;
	
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	/**
	 * Define witch enterprise is reserving the stock
	 */
	@ManyToOne(targetEntity = Enterprise.class)
	@JoinColumn(name = "enterprise_id", referencedColumnName = "id")
	private Enterprise enterprise;
	
	/**
	 * Defines how reserved the product for auditing
	 */
	@Column(name = "username", length = 15, nullable = false)
	private String username;
	
	@Column(name = "quantity", length = 11, nullable = false)
	private Integer quantity;

    @Column(name = "price", length = 6, nullable = false)
    private BigDecimal price;
	
	/**
	 * Commits the reservation
	 */
	@Column(name = "reservationState", length = 6)
	private ReservationState reservationState;
	
	/**
	 * Minimal Constructor
	 */
	public Reservation() {
	}

	/**
	 * @param id
	 * @param checkOut
	 * @param stock
	 * @param product
	 * @param enterprise
	 * @param username
	 * @param quantity
	 */
	public Reservation(Long id, Date checkOut, Stock stock, Product product, 
                Enterprise enterprise, String username, Integer quantity) {
            this.id = id;
            this.checkOut = checkOut;
            this.stock = stock;
            this.product = product;
            this.enterprise = enterprise;
            this.username = username;
            this.quantity = quantity;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the checkOut
	 */
	public Date getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the enterprise
	 */
	public Enterprise getEnterprise() {
		return enterprise;
	}

	/**
	 * @param enterprise the enterprise to set
	 */
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

	/**
	 * @return the reservationState
	 */
	public ReservationState getReservationState() {
		return reservationState;
	}

	/**
	 * @param reservationState the reservationState to set
	 */
	public void setReservationState(ReservationState reservationState) {
		this.reservationState = reservationState;
	}
    
}