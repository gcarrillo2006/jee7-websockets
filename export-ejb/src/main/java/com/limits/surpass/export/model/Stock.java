package com.limits.surpass.export.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
/**
 * Entity that manages the stock of a product by an enterprise
 * @author German
 *
 */
@Entity
@Table(name = "stock", schema = "application")
@NamedQueries({
    @NamedQuery(name = "findStocksByProduct", query = "select s from Stock s "
        + "where s.product = :product")
})
public class Stock implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20)
	private Long id;
	
	@Column(name = "code", length = 15)
	private String code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	@Column(name = "check_in")
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkIn;
	
	@Column(name = "vigency_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date vigencyDate;
	
	@Column(name = "unitary_cost", precision = 2, length = 10, nullable = true)
	private BigDecimal unitaryCost;
	
	@Column(name = "unitary_price", precision = 2, length = 10, nullable = false)
	private BigDecimal unitaryPrice;
	
	@Column(name = "quantity", length = 11, nullable = false)
	private Integer quantity;
	
	/**
	 * Defines how reserved the product for auditing
	 */
	@Column(name = "username", length = 15, nullable = false)
	private String username;
	
	@OneToMany(mappedBy = "stock")
	private Set<Reservation> reservationList;
	
	//Contains a map of stock's that are going to be update JUST IN CASE
	//The integer is the amount of stock that needs to be reserved
	@Transient
	private Map<Stock,Integer> stockMap;

	/**
	 * Minimal Constructor
	 */
	public Stock() {
	}

	/**
	 * @param id
	 * @param code
	 * @param product
	 * @param checkIn
	 * @param vigencyDate
	 * @param unitaryCost
	 * @param unitaryPrice
	 * @param quantity
	 */
	public Stock(Long id, String code, Product product, Date checkIn,
			Date vigencyDate, BigDecimal unitaryCost, 
                        BigDecimal unitaryPrice, Integer quantity) {
            this.id = id;
            this.code = code;
            this.product = product;
            this.checkIn = checkIn;
            this.vigencyDate = vigencyDate;
            this.unitaryCost = unitaryCost;
            this.unitaryPrice = unitaryPrice;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the checkIn
	 */
	public Date getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the vigencyDate
	 */
	public Date getVigencyDate() {
		return vigencyDate;
	}

	/**
	 * @param vigencyDate the vigencyDate to set
	 */
	public void setVigencyDate(Date vigencyDate) {
		this.vigencyDate = vigencyDate;
	}

	/**
	 * @return the unitaryCost
	 */
	public BigDecimal getUnitaryCost() {
		return unitaryCost;
	}

	/**
	 * @param unitaryCost the unitaryCost to set
	 */
	public void setUnitaryCost(BigDecimal unitaryCost) {
		this.unitaryCost = unitaryCost;
	}

	/**
	 * @return the unitaryPrice
	 */
	public BigDecimal getUnitaryPrice() {
		return unitaryPrice;
	}

	/**
	 * @param unitaryPrice the unitaryPrice to set
	 */
	public void setUnitaryPrice(BigDecimal unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the reservationList
	 */
	public Set<Reservation> getReservationList() {
		return reservationList;
	}

	/**
	 * @param reservationList the reservationList to set
	 */
	public void setReservationList(Set<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	/**
	 * @return the stockMap
	 */
	public Map<Stock,Integer> getStockMap() {
		return stockMap;
	}

	/**
	 * @param stockMap the stockMap to set
	 */
	public void setStockMap(Map<Stock,Integer> stockMap) {
		this.stockMap = stockMap;
	}
}